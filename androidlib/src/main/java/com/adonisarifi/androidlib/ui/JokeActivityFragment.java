package com.adonisarifi.androidlib.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adonisarifi.androidlib.R;
import com.adonisarifi.androidlib.utils.Constants;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTextView = (TextView) rootView.findViewById(R.id.text_view_joke);
        jokeTextView.setText(getActivity().getIntent().getStringExtra(Constants.EXTRA_JOKE_KEY));
        return rootView;
    }
}
