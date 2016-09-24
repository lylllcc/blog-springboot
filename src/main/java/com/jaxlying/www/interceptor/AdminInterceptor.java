package com.jaxlying.www.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jaxlying on 2016/9/24.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object handler) throws IOException {
        if (httpServletRequest.getSession().getAttribute("root") != null){
            return true;
        }
        httpServletResponse.sendRedirect("/login?next=".concat(httpServletRequest.getRequestURI()));
        return false;


    }

}
