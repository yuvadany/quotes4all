package com.today.quote.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class QuoteUtil {
    public String getRandomNumber() {
        Random random = new Random();
        int min = 1;
        int max = 99;
        return  String.valueOf(random.nextInt(max + min) + min);
    }

}
