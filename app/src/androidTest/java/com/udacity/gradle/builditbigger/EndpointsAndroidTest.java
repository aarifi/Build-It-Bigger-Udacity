package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * Created by AdonisArifi on 26.3.2016 - 2016 . FinalProject Build It Bigger
 */
public class EndpointsAndroidTest extends AndroidTestCase {

    private static final String LOG_TAG = "EndpointsAndroidTest";

    @SuppressWarnings("unchecked")
    public void testResult() throws InterruptedException {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        final CountDownLatch signal = new CountDownLatch(1);
        final String[] result = {""};
        JokeListener jokeListener = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new JokeListener() {
            @Override
            public void onResult(String jokeresult) {
                assertNotNull(jokeresult);
                result[0] = jokeresult;
                signal.countDown();
            }
        });

        signal.await();
        Log.d(LOG_TAG, result[0]);
    }

}