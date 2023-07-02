package com.today.quote;

import com.today.quote.model.Quote;
import com.today.quote.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class Quotes4allApplicationTests {
    @MockBean
    QuoteService quoteService;

    @Test
    void getQuoteTest() {
        when(quoteService.getQuote()).thenReturn(new Quote(1, "Life is not about getting and having, it is about giving and being.", "Kevin Kruse", "Life is not about getting and having, it is about giving and being.", 23));
        assertEquals(1, quoteService.getQuote().getId());
    }

    @Test
    void findAllByTagTest() {
        when(quoteService.findAllByTag(5)).thenReturn(Stream.of(new Quote(76, "Life is not about getting and having, it is about giving and being.", "Kevin Kruse", "Life is not about getting and having, it is about giving and being.", 23),
                new Quote(7, "Life is not about getting and having, it is about giving and being.", "Kevin Kruse", "Life is not about getting and having, it is about giving and being.", 23),
                new Quote(5, "Life is not about getting and having, it is about giving and being.", "Kevin Kruse", "Life is not about getting and having, it is about giving and being.", 23)).collect(Collectors.toList()));
        assertEquals(3, quoteService.findAllByTag(5).size());
    }

}
