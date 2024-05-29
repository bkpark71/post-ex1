package org.example.post_ex1.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // 사용자의 요청을 가지고, 어떤 화면으로 들어온 요청인지, 어떤 핸들러가 처리하고 있는지
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String URI = req.getRequestURI();
        log.info("Request ==> {}", URI);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
