package com.today.quote.controller;

import com.today.quote.model.Quote;
import com.today.quote.service.QuoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    @GetMapping("/quote")
    @ApiOperation(value = "Welcome Quote")
    public ModelAndView getQuote() {
        var quote = " Have a wonderful day...";
        var quoteContent = quoteService.getQuote();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quote", quote);
        modelAndView.addObject("QuoteOfToday", quoteContent.getQuote());
        modelAndView.addObject("Author", quoteContent.getAuthor());
        modelAndView.addObject("id", quoteContent.getId());
        modelAndView.addObject("rating", quoteContent.getLikes());
        List<Quote> similarQuotes = quoteService.findAllByTag(quoteContent.getId());
        modelAndView.addObject("similarQuotes", similarQuotes);
        return modelAndView;
    }
}
