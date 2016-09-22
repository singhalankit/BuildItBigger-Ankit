package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.ankit_pc.myapplication.backend.myApi.MyApi;
import com.example.jokedisplay.JokeDisplay;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;


import java.io.IOException;

/**
 * Created by ANKIT_PC on 04-09-2016.
 */
public class JokeAsyncTask extends AsyncTask<MainActivityFragment,Void,String> {
    private MainActivityFragment mainActivityFragment;
    private static MyApi myApiService = null;
    private Context context;
    @Override
    protected String doInBackground(MainActivityFragment... params) {

        if(myApiService == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://my-first-backend-142416.appspot.com/_ah/api/");

            myApiService = builder.build();
        }
        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();
        //String joke = null;

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return  e.getMessage();
        }

        //return joke;

    }

    @Override
    protected void onPostExecute(String result) {
        /*// Create Intent to launch JokeFactory Activity
        Intent intent = new Intent(context, JokeDisplay.class);
        // Put the string in the envelope
        intent.putExtra("joke_wrap",result);
        context.startActivity(intent);*/

        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        mainActivityFragment.loadedJoke= result;
        mainActivityFragment.launchDisplayJokeActivity();

    }



}
