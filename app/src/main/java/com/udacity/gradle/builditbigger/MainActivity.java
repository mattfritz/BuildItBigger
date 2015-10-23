package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mattfritz.jokesmodule.JokesModule;
import com.mattfritz.jokesactivitymodule.JokeActivity;


public class MainActivity extends ActionBarActivity {
    private static final String JOKE_TAG = "com.mattfritz.jokesactivitymodule.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        String joke = new JokesModule().getRandomJoke();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JOKE_TAG, joke);
        startActivity(intent);
    }


}
