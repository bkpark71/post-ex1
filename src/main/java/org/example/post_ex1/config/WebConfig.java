package org.example.post_ex1.config;

import org.example.post_ex1.filter.LogFilter;
import org.example.post_ex1.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new LogFilter());
        frb.setOrder(1);
        frb.addUrlPatterns("/*");
        return frb;
    }

    @Bean
    public FilterRegistrationBean loginCheckFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new LoginCheckFilter());
        frb.setOrder(2);
        frb.addUrlPatterns("/*");
        return frb;
    }
}
