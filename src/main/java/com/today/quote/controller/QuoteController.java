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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Quote> similarQuotes = quoteService.findAllByTag(quoteContent.getTag());
        /* similarQuotes.add(new Quote(3, "Nice Day", "uv", "challenge", 2));
        similarQuotes.add(new Quote(7, "more failures teaches", "Uvab", "success", 2));
        similarQuotes.add(new Quote(8, "win the situation", "rt", "positive", 8));
        similarQuotes.add(new Quote(9, "Progress always wins", "Iop", "failure", 12));  */
        modelAndView.addObject("similarQuotes", similarQuotes);
        return modelAndView;
    }
}
