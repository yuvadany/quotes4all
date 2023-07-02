package com.today.quote.service.impl;

import com.today.quote.model.Quote;
import com.today.quote.repo.QuotesRepository;
import com.today.quote.service.QuoteService;
import com.today.quote.util.QuoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new NoSuchElementException()))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new NoSuchElementException()))
                .bodyToMono(Quote.class)
                .block();
    }


    @Override
    public List<Quote> findAllByTag(int id) {
        List<Quote> similarQuotes = new ArrayList<>();
        if (quotesRepository.findById(id).isPresent()) {
            Optional<Quote> quoteDisplayed = quotesRepository.findById(id);
            if (quoteDisplayed.isPresent() && !quoteDisplayed.get().getTag().isEmpty()) {
                similarQuotes = quotesRepository.findAllByTag(quotesRepository.findById(id).get().getTag());
            }
        }
        return similarQuotes;
    }
}
