package com.udacity.gradle.builditbigger;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ANKIT_PC on 06-09-2016.
 */
public class JokeAsyncTaskTest {


    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.testFlag = true;
        new JokeAsyncTask().execute(fragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + fragment.loadedJoke, fragment.loadedJoke != null);
    }

}
