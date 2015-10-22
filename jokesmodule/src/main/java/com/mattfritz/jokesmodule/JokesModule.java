package com.mattfritz.jokesmodule;

import java.util.ArrayList;

public class JokesModule {
    private ArrayList<String> mJokes;

    public JokesModule() {
        mJokes = new ArrayList<String>();
        mJokes.add("I poured root beer into a square cup. Now I just have beer.");
        mJokes.add("Borrow money from pessimists -- they don't expect it back.");
        mJokes.add("Eagles may soar, but weasels don't get sucked into jet engines.");
        mJokes.add("Why did the scarecrow win an award? He was outstanding in his field.");
        mJokes.add("What do you call a drummer without a girlfriend? Homeless.");
    }

    public String getRandomJoke() {
        int randomIndex = (int) Math.floor(Math.random() * mJokes.size());
        return mJokes.get(randomIndex);
    }

}
