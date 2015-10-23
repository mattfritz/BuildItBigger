package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    String mResult = null;
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeGetTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask();

        // Get string result from listener
        task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                mResult = result;
                signal.countDown();
            }
        }).execute(getContext());

        // Block and wait for asynctask to complete
        signal.await();

        assertFalse(TextUtils.isEmpty(mResult));
    }
}