package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.mattfritz.jokes.backend.myApi.MyApi;
import com.mattfritz.jokesactivitymodule.JokeActivity;

import java.io.IOException;

/**
 * Created by matt on 10/23/15.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static final String JOKE_TAG = "com.mattfritz.jokesactivitymodule.JOKE";
    private static MyApi myApiService = null;
    private Context context;
    private EndpointsAsyncTaskListener mListener;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1107.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Run listener callback if an onComplete listener is defined
        if (mListener != null) {
            mListener.onComplete(result);
        }

        // Start JokeActivity with returned data
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_TAG, result);
        context.startActivity(intent);
    }

    public EndpointsAsyncTask setListener(EndpointsAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }

    public static interface EndpointsAsyncTaskListener {
        // Require onComplete override when creating listener
        public void onComplete(String result);
    }
}