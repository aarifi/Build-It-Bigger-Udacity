package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.adonisarifi.androidlibraryjokes.MainActivityLib;
import com.javalibrary.JokeClass;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.instructions_text_view)
    TextView instructions_text_view;
    @Bind(R.id.button_telljoke)
    Button button_telljoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
/*
    public void tellJoke(View view){
*//*
            Intent myIntent = new Intent(this, MainActivityLib.class);
            startActivity(myIntent);*//*

        JokeClass jokeClass = new JokeClass();
        instructions_text_view.setText(jokeClass.getRandomJoke());

    }*/

    @OnClick(R.id.button_telljoke)
    public void setOnClick_button_telljoke() {
      Intent myIntent = new Intent(this, MainActivityLib.class);
        startActivity(myIntent);
        JokeClass jokeClass = new JokeClass();
        instructions_text_view.setText(jokeClass.getRandomJoke());

    }


}
