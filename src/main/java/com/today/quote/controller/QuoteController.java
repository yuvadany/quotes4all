package com.today.quote.controller;

import com.today.quote.service.QuoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {
@Autowired
    QuoteService quoteService;
    @GetMapping("/quote")
    @ApiOperation(value = "Welcome Quote")
    public  ModelAndView getQuote(){
        var quote =  " Have a wonderful day...";
        var quoteContent = quoteService.getQuote();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote",quote);
        modelAndView.addObject("QuoteOfToday",quoteContent.getquote());
        modelAndView.addObject("Author",quoteContent.getAuthor());
        modelAndView.addObject("id",quoteContent.getId());
        modelAndView.addObject("rating",quoteContent.getRating());
        return modelAndView;
    }
}
