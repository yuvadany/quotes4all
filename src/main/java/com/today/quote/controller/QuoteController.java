package com.today.quote.controller;

import com.today.quote.model.Quote;
import com.today.quote.service.QuoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/quotes/services")
@Api("Quotes")
public class QuoteController {
    private static final Logger logger = LoggerFactory.getLogger(QuoteController.class);
    @Autowired
    QuoteService quoteService;

    @GetMapping("/quote")
    @ApiOperation(value = "Get Random Quote and Similar quotes")
    public ModelAndView getQuote() {
        ModelAndView modelAndView = new ModelAndView("index");
        try {
            var quoteContent = quoteService.getQuote();
            modelAndView.addObject("QuoteOfToday", quoteContent.getQuote());
            modelAndView.addObject("Author", quoteContent.getAuthor());
            modelAndView.addObject("id", quoteContent.getId());
            modelAndView.addObject("rating", quoteContent.getLikes());
            List<Quote> similarQuotes = quoteService.findAllByTag(quoteContent.getId());
            if (!similarQuotes.isEmpty()) {
                modelAndView.addObject("similarQuotes", similarQuotes);
            } else {
                modelAndView.addObject("similarQuotes", "No Similar Quotes");
                logger.info("No Similar Quotes found");
            }
            return modelAndView;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new NoSuchElementException();
        }
    }
}
