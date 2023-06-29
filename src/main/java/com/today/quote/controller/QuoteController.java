package com.today.quote.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {

    @GetMapping("/welcome")
    @ApiOperation(value = "Welcome")
    public  String welcome(){
        return "welcome........";
    }
}
