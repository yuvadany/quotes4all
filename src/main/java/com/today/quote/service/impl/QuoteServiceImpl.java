package com.today.quote.service.impl;

import com.today.quote.model.Quote;
import com.today.quote.service.QuoteService;
import com.today.quote.util.QuoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    WebClient.Builder webClient;
    @Value("${url.one.quote}")
    private String quoteUrl;
    @Override
    public Quote getQuote() {
        quoteUrl = quoteUrl+"/4";
        var quote =   webClient.build()
                .get()
                .uri(quoteUrl )
                .retrieve()
                .bodyToMono(Quote.class)
                .block();

        return quote;
    }
}
