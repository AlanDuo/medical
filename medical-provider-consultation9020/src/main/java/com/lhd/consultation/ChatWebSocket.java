package com.lhd.consultation;

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
//    private static ChatService chatService;
//    @Autowired
//    public void  setChatService(ChatService chatService){
//        ChatWebSocket.chatService=chatService;
//    }
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
    }
    @OnMessage
    public void onMessage(String message, Session session){

    }
    @OnClose
    public void onClose(){
        LOGGER.info("close");
    }
    @OnError
    public void onError(Session session, Throwable error){
        LOGGER.info("error");
    }

}
