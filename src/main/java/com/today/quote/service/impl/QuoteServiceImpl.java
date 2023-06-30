package com.today.quote.service.impl;

import com.today.quote.model.Quote;
import com.today.quote.repo.QuotesRepository;
import com.today.quote.service.QuoteService;
import com.today.quote.util.QuoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    QuotesRepository quotesRepository;
    @Autowired
    WebClient.Builder webClient;
    @Value("${url.one.quote}")
    private String quoteUrl;

    @Override
    public Quote getQuote() {
        var randomQuoteUrl = "";
        randomQuoteUrl = quoteUrl + new QuoteUtil().getRandomNumber();
        return webClient.build()
                .get()
                .uri(randomQuoteUrl)
                .retrieve()
                .bodyToMono(Quote.class)
                .block();
    }

    @Override
    public List<Quote> findAllByTag(String tag) {
        return quotesRepository.findAll();
    }
}
