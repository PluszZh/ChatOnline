package org.lf.diary.controller.chat;

import org.lf.diary.model.User;
import org.lf.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author: PengZH
 * @Date: 2020/3/12 20:22
 * @Description:
 */

@Controller
public class LoginChat {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(@RequestParam(value = "id") Long id, HttpSession session){
        User byId = userService.findById(id);
        session.setAttribute("user",byId);
        return "/chat/index.html";
    }
}
