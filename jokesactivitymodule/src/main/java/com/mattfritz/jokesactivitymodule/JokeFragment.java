package com.mattfritz.jokesactivitymodule;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {
    private static final String JOKE_TAG = "com.mattfritz.jokesactivitymodule.JOKE";
    public JokeFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeBody = (TextView) rootView.findViewById(R.id.joke_body);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String joke = intent.getStringExtra(JOKE_TAG);
            jokeBody.setText(joke);
        } else {
            jokeBody.setText(R.string.joke_empty_text);
        }
        return rootView;
    }
}
