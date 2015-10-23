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
        mJokes.add("I bought the world's worst thesaurus yesterday. Not only is it terrible, it's terrible.");
        mJokes.add("Why didn't the lifeguard save the drowning hippie? He was too far out, man.");
        mJokes.add("And God said to John, come forth and you shall be granted eternal life. But John came fifth and won a toaster");
        mJokes.add("What can think the unthinkable? An itheberg.");
        mJokes.add("A computer scientist goes to get some groceries. Before he leaves, his wife tells him \"while you're there, get some eggs\". He never comes home.");
    }

    public String getRandomJoke() {
        int randomIndex = (int) Math.floor(Math.random() * mJokes.size());
        return mJokes.get(randomIndex);
    }

}
