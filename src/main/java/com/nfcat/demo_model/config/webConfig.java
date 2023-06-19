package com.nfcat.demo_model.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/app.html","App.html")
                .excludePathPatterns("/login","/","login.html");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
