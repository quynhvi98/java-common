//package com.tqt.javacommon.utils;
//
//import io.micronaut.http.HttpStatus;
//import io.micronaut.http.filter.FilterChain;
//import io.micronaut.websocket.annotation.WebSocketComponent;
//
//import java.io.IOException;
//
///**
// * Posted from Jan 15, 2020, 11:55 AM
// *
// * @author Vi Quynh (vi.quynh.31598@gmail.com)
// */
//public class JWTAuthenticationFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest req,
//                                    HttpServletResponse res,
//                                    FilterChain chain) throws IOException, ServletException {
//        Authentication authentication = getAuthentication(req);
//        if (null != authentication) {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(req, res);
//        } else {
//            if (req.getRequestURI().indexOf("/swagger-ui.html") >= 0
//                    || req.getRequestURI().indexOf("/webjars") >= 0
//                    || req.getRequestURI().indexOf("/swagger-resources") >= 0
//                    || req.getRequestURI().indexOf("/v2/api-docs") >= 0
//            ) {
//                res.setStatus(HttpStatus.OK.value());
//                chain.doFilter(req, res);
//            } else {
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//                res.setStatus(HttpStatus.BAD_REQUEST.value());
//                chain.doFilter(req, res);
//            }
//        }
//    }
//}
