package com.example;

import java.util.Random;

public class Joke {

    // just grabbed some jokes from the internet
    private String[] jokes = {
            "How many programmers does it take to change a light bulb?\n" +
                    "None – It’s a hardware problem",
            "Why do programmers always mix up Halloween and Christmas? \n" +
                    "Because Oct 31 equals Dec 25.",
            "There are only 10 kinds of people in this world: those who know binary and those who don’t.",
            "A programmer walks to the butcher shop and buys a kilo of meat.  An hour later he comes back upset that the butcher shortchanged him by 24 grams.",
            "Programming is 10% science, 20% ingenuity, and 70% getting the ingenuity to work with the science.",
            "Programming is like sex:\n" +
                    "One mistake and you have to support it for the rest of your life.",
            "There are three kinds of lies: Lies, damned lies, and benchmarks.",
            "All programmers are playwrights, and all computers are lousy actors.",
            "Have you heard about the new Cray super computer?  It’s so fast, it executes an infinite loop in 6 seconds.",
            "The generation of random numbers is too important to be left to chance.",
            "The computer is mightier than the pen, the sword, and usually, the programmer.",
            "Q: What is the difference between snowmen and snowwomen? \n" +
                    "A: Snowballs.",
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "When wearing a bikini,women reveal 90% of their body....men are so polite they only look at the covered parts",
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "Isn't it great to live in the 21st century? Where deleting history has become more important than making it."
    };

    public Joke(){

    }

    public String getJoke(){
        Random random = new Random();

        return jokes[random.nextInt(jokes.length)];
    }
}
