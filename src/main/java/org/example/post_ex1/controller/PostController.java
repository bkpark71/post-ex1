package org.example.post_ex1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.post_ex1.entity.Post;
import org.example.post_ex1.entity.User;
import org.example.post_ex1.service.PostService;
import org.example.post_ex1.service.UserService;
import org.example.post_ex1.session.SessionInfo;
import org.example.post_ex1.session.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/post/new")
    public String addNewPost(HttpServletRequest req,
                             Model model) {
        HttpSession session = req.getSession(false);
        log.info("session = {}", session);
        if(session != null) { // 로그인 하지 않으면 null, 로그인 한 상태이면 존재하는 세션을 반환해온다.
            UserInfo userInfo = (UserInfo) session.getAttribute(SessionInfo.SESSION_NAME);
            log.info("userInfo = {}", userInfo);
            model.addAttribute("name", userInfo.getName());
        }

//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("userId")) {
//                    User user = userService.getUserInfoByUserId(cookie.getValue());
//                    model.addAttribute("name", user.getName());
//                }
//            }
//        }
        Post post = new Post();
        model.addAttribute("post", post);

        return "post/postAdd";
    }

    @PostMapping("/post/new")
    public String addNewPost(HttpServletRequest req,
            @ModelAttribute Post post) {
        HttpSession session = req.getSession(false);
        if(session != null) {
            UserInfo userInfo = (UserInfo) session.getAttribute(SessionInfo.SESSION_NAME);
            post.setUserId(userService.getUserInfoById(userInfo.getId()).getUserId());
        }
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("userId")) {
//                    post.setUserId(cookie.getValue());
//                }
//            }
//        }
        postService.addPost(post);
        return "redirect:/post/all";
    }

    @GetMapping("/post/all")
    public String allPosts(HttpServletRequest req,
                            Model model) {

        HttpSession session = req.getSession(false);
        if(session != null) {
            UserInfo userInfo = (UserInfo) session.getAttribute(SessionInfo.SESSION_NAME);
            model.addAttribute("name", userInfo.getName());
        }

//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("userId")) {
//                    User user = userService.getUserInfoByUserId(cookie.getValue());
//                    model.addAttribute("name", user.getName());
//                }
//            }
//        }

        model.addAttribute("posts", postService.getAllPosts());
        return "post/postView";
    }
}
