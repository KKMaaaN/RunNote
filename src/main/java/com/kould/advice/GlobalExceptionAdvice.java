package com.kould.advice;

import com.kould.Bean.ErrorBean;
import com.kould.Bean.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request,
                                                  Exception e) {
        ErrorBean eB = new ErrorBean(request.getRequestURL().toString(),e.getMessage()){};
        Message msg = new Message<ErrorBean>(eB,"500"){} ;
        return msg ;
    }
}
