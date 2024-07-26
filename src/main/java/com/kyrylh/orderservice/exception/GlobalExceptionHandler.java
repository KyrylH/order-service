package com.kyrylh.orderservice.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleOrderExceptions(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("containsMessage", true);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
