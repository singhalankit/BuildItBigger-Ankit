package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.jokedisplay.JokeDisplay;


/**
 * Created by ANKIT_PC on 06-09-2016.
 */
public class MainActivityFragment extends Fragment {
    public boolean testFlag = false;
    ProgressBar progressBar = null;
    public String loadedJoke = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        //AdView mAdView = (AdView) root.findViewById(R.id.adView);

        Button button = (Button) root.findViewById(R.id.jokeButton);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        /*AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);*/


        button.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v) {
                                          progressBar.setVisibility(View.VISIBLE);
                                          getJoke();
                                      }
                                  }

        );
        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.GONE);

        return root;
    }

    public void getJoke(){
        new JokeAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity() {
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokeDisplay.class);
            intent.putExtra(context.getString(R.string.joke_text), loadedJoke);
            //Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}

