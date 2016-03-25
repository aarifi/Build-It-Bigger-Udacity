package com.udacity.gradle.builditbigger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adonisarifi.androidlib.ui.JokeActivity;
import com.adonisarifi.androidlib.utils.Constants;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeListener;
import com.udacity.gradle.builditbigger.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements JokeListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.progress_bar_joke)
    ProgressBar mSpinner;

    @Bind(R.id.instructions_text_view)
    TextView mInstructionsTextView;

    @Bind(R.id.button_tell_joke)
    Button button_tell_joke;


    boolean mStopSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button_tell_joke)
    public void setOnClicktellJoke() {

            startSpinner();
            startEndpointAsynTask();

    }

    private void startSpinner() {
        if (button_tell_joke != null) {
            button_tell_joke.setVisibility(View.GONE);
            mSpinner.setVisibility(View.VISIBLE);
        }
    }

    private void stopSpinner() {
        if (mSpinner != null) {
            button_tell_joke.setVisibility(View.VISIBLE);
            mSpinner.setVisibility(View.GONE);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mStopSpinner) {
            stopSpinner();
            mStopSpinner = false;
        }
    }


    public void startEndpointAsynTask() {
        try {
            startSpinner();
            new EndpointsAsyncTask().execute(this);
        } catch (Exception e) {
            e.getMessage();
        }

    }


    @Override
    public void onResult(String jokeresult) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(Constants.EXTRA_JOKE_KEY, jokeresult);
        startActivity(intent);
        mStopSpinner = true;
        Log.i(LOG_TAG, "joke fetched! " + jokeresult);
    }
}
