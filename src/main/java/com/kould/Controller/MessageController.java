package com.kould.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {
    @RequestMapping(value = "/")
    public String home() {
        return "歡迎來到RunNote" ;
    }

    @Secured({"ROLE_user"})
    @RequestMapping(value = "message",method = RequestMethod.POST)
    public Object userMsg() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest() ;
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse() ;
        Map<String,String> map = new HashMap<String,String>() ;
        map.put("客戶端IP地址",request.getRemoteAddr());
        map.put("客戶端響應編碼",response.getCharacterEncoding()) ;
        map.put("SessionID",request.getSession().getId()) ;
        map.put("項目真實路徑",request.getServletContext().getRealPath("/")) ;
        return map ;
    }
}
