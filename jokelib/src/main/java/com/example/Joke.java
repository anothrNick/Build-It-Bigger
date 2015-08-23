package com.example;

import java.util.Random;

public class Joke {

    private String[] jokes = {
            "How many programmers does it take to change a light bulb?\n" +
                    "None – It’s a hardware problem",
            "Why do programmers always mix up Halloween and Christmas? \n" +
                    "Because Oct 31 equals Dec 25."
    };

    public Joke(){

    }

    public String getJoke(){
        Random random = new Random();

        return jokes[random.nextInt(jokes.length)];
    }
}
