package com.lhd.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.service.UserService;
import com.lhd.manager.vo.UserListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/user_list")
    public TableVO getUserList(String phone, String username,
                               @RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        List<UserListVO> userListVOList=userService.getUserList(phone, username);
        PageInfo pageInfo=new PageInfo<>(userListVOList);
        return new TableVO(pageInfo,userListVOList);
    }
}
