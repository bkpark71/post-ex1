package org.example.post_ex1.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.post_ex1.session.SessionInfo;
import org.example.post_ex1.session.UserInfo;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {
    private static final String[] whitelist =
            {"/login", "/favicon.ico", "/logout", "/post/all"};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        log.info("loginCheck ==> {}", req.getRequestURI());
        if(!PatternMatchUtils.simpleMatch(whitelist, req.getRequestURI())){
            HttpSession session = req.getSession(false);
            log.info("session ? {}", session);
            if(session != null) {
                UserInfo userInfo = (UserInfo) session.getAttribute(SessionInfo.SESSION_NAME);
                log.info("userInfo = {}", userInfo.getName());

            } else {
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
