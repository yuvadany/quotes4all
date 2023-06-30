package com.today.quote.service;

import com.today.quote.model.Quote;

import java.util.List;

public interface QuoteService {

    public Quote getQuote();
    List<Quote> findAllByTag(int id);
}
