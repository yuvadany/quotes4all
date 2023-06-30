package com.today.quote.util;

import java.util.Random;

public class QuoteUtil {
    public String getRandomNumber() {
        Random random = new Random();
        int min = 1;
        int max = 100;
        return  String.valueOf(random.nextInt(max + min) + min);
    }

}
