package com.today.quote.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView quoteNotFoundException() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("error","NotFound");
        modelAndView.addObject("error_quote","Quote Page is down. Have a wonderful day. All will be fine. Kindly try after some time.");
        log.error("Quote Server is not responding");
        return modelAndView;
    }

}