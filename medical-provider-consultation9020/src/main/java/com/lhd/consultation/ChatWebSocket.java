package com.lhd.consultation;

import com.alibaba.fastjson.JSONObject;
import com.lhd.consultation.entities.User;
import com.lhd.consultation.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/13
 */

@RestController
@ServerEndpoint(value="/websocket/{userId}")
public class ChatWebSocket {
    private static ChatService chatService;
    @Autowired
    public void  setChatService(ChatService chatService){
        ChatWebSocket.chatService=chatService;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatWebSocket.class);

    private String userId;
    private Session session;
    private static Map<String, ChatWebSocket> userClient=new HashMap<>();
    private static Map<String, ChatWebSocket> doctorClient=new HashMap<>();

    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session){
        LOGGER.info("Connect success!");
        this.userId=userId;
        this.session=session;
        if(chatService.isDoctor(Long.parseLong(userId))){
            doctorClient.put(userId,this);
        } else{
            userClient.put(userId,this);
        }
    }
    @OnMessage
    public void onMessage(String message, Session session){
        LOGGER.info(message);
        JSONObject jsonObject=JSONObject.parseObject(message);
        String to=jsonObject.getString("toUser");
        String toMessage=jsonObject.getString("toMessage");
        ChatWebSocket chat;
        if(chatService.isDoctor(Long.parseLong(to))){
            chat=doctorClient.get(to);
            if(null!=chat) {
                Session toSession = chat.session;
                if (toSession.isOpen()) {
                    System.out.println(this.userId+"发送给的医生为"+to);
                    User user=chatService.getUser(Long.parseLong(userId));
                    toSession.getAsyncRemote().sendText(this.userId+"," +user.getUserImg()+ "," + toMessage);
                    //chatService.addChatRecord(Long.parseLong(this.userId), Long.parseLong(to), toMessage);
                }
            }
            else{
                session.getAsyncRemote().sendText("您好！对方不在线，请稍后联系！");
            }
        }else{
            if(null!=to && !"undefined".equals(to) && !"NaN".equals(to)) {
                chat = userClient.get(to);
                if (null != chat) {
                    Session toSession = chat.session;
                    if (toSession.isOpen()) {
                        System.out.println(this.userId+"医生发送给的用户为"+to);
                        User user=chatService.getUser(Long.parseLong(userId));
                        toSession.getAsyncRemote().sendText(this.userId+"," +user.getUserImg()+ "," + toMessage);
                        //chatService.addChatRecord(Long.parseLong(this.userId), Long.parseLong(to), toMessage);
                    }
                } else {
                    session.getAsyncRemote().sendText("您好！对方不在线，请稍后联系！");
                }
            }else{
                session.getAsyncRemote().sendText("发送对象为空");
            }
        }
    }
    @OnClose
    public void onClose(){
        LOGGER.info("close");
    }
    @OnError
    public void onError(Session session, Throwable error){
        LOGGER.info("error");
        error.printStackTrace();
    }

}
