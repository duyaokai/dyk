//n;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//package com.testd.config;//package com.testd.config;
//////
//////
//////import com.testd.pojo.YkAdmi
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class MyAdminInterceptor extends HandlerInterceptorAdapter {
//        @Override
//        public boolean preHandle(HttpServletRequest httpServletRequest,
//                                 HttpServletResponse httpServletResponse,
//                                 Object o) throws Exception {
//            boolean flag = false;
//            YkAdmin user = (YkAdmin) httpServletRequest.getSession().getAttribute("user");
//            System.out.println(user);
//            if (user == null) {
//                ;
//                httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
//            } else {
//                flag = true;
//            }
//
//
//            return flag;
//        }
//}
//
