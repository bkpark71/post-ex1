package org.example.post_ex1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.post_ex1.entity.User;
import org.example.post_ex1.service.LoginService;
import org.example.post_ex1.service.UserService;
import org.example.post_ex1.session.SessionInfo;
import org.example.post_ex1.session.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        HttpServletRequest req){
//                        HttpServletResponse res) {
        if(loginService.login(userId, password)) {
            HttpSession session = req.getSession(true);
            User user = userService.getUserInfoByUserId(userId);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setName(user.getName());
            session.setAttribute(SessionInfo.SESSION_NAME , userInfo);

//            Cookie cookie = new Cookie("userId", userId);
//            res.addCookie(cookie);
            return "redirect:/post/all";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if(session != null) session.invalidate();
//        Cookie cookie = new Cookie("userId", null);
//        cookie.setMaxAge(0);
//        res.addCookie(cookie);
        return "login/login";
    }
}
