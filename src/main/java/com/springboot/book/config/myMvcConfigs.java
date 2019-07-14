package com.springboot.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class myMvcConfigs extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/mainui.html").setViewName("mainui");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/booklist.html").setViewName("booklist");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/index.html","/","/login.html","/webjars/bootstrap/4.0.0/css/bootstrap.css","/mainui.html","user/login");
//    }
    @Bean
 public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
 }


}
