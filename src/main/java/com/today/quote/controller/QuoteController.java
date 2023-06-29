package com.today.quote.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {

    @GetMapping("/quote")
    @ApiOperation(value = "Welcome Quote")
    public  ModelAndView getQuote(){
        var quote =  " Have a wonderful day...";
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote",quote);
        return modelAndView;
    }
}
