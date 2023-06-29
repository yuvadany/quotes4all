package com.today.quote.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {
    @GetMapping("/quote")
    @ApiOperation(value = "Welcome Quote")
    public  String getQuote(){
        return " Have a wonderful day...";
    }
}
