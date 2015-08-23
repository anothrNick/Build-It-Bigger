package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nick on 8/23/2015.
 */
public class GetJokeTaskTest extends InstrumentationTestCase implements JokeTask.TaskResponseListener {
    String TAG = "GetJokeTaskTest";
    JokeTask jokeTask;
    String joke = "";
    CountDownLatch signal = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
        jokeTask = new JokeTask(GetJokeTaskTest.this);
    }

    public void testGetJoke() throws Throwable {

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Attempting to get joke");
                jokeTask.execute();
                try {
                    signal.await(5, TimeUnit.SECONDS);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onDone(String joke) {
        Log.d(TAG, "Received joke: " + joke);
        assertTrue("Joke is empty", !joke.isEmpty());
        signal.countDown();
    }
}
