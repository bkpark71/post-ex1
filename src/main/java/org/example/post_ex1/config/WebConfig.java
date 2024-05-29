package org.example.post_ex1.config;

import lombok.extern.java.Log;
import org.example.post_ex1.filter.LogFilter;
import org.example.post_ex1.filter.LoginCheckFilter;
import org.example.post_ex1.interceptor.LogInterceptor;
import org.example.post_ex1.interceptor.LoginCheckInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor())
//                .order(1)
//                .addPathPatterns("/**");
//
//        registry.addInterceptor(new LoginCheckInterceptor())
//                .order(2)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login", "/logout", "/post/all");
//    }
//}


//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public FilterRegistrationBean logFilter(){
//        FilterRegistrationBean frb = new FilterRegistrationBean();
//        frb.setFilter(new LogFilter());
//        frb.setOrder(1);
//        frb.addUrlPatterns("/*");
//        return frb;
//    }
//
//    @Bean
//    public FilterRegistrationBean loginCheckFilter(){
//        FilterRegistrationBean frb = new FilterRegistrationBean();
//        frb.setFilter(new LoginCheckFilter());
//        frb.setOrder(2);
//        frb.addUrlPatterns("/*");
//        return frb;
//    }
//}
