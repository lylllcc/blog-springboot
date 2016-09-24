package com.jaxlying.www.config;

import com.jaxlying.www.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jaxlying on 2016/9/24.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

//    @Override
//    public void addInterceptors(InterceptorRegistry interceptorRegistry){
//        interceptorRegistry
//                .addInterceptor(new AdminInterceptor())
//                .addPathPatterns("/admin");
//
//    }
}
