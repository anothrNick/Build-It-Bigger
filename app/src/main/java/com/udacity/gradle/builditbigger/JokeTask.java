package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.nick.myapplication.jokes.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nicksjostrom.jokelibrary.JokeActivity;

import java.io.IOException;

/**
 * Created by Nick on 8/23/2015.
 */
public class JokeTask extends AsyncTask<String, Void, String> {
    private Context mContext = null;
    private TaskResponseListener mListener = null;
    private static MyApi jokeApi = null;

    public JokeTask() {}

    public JokeTask(Context context) {
        mContext = context;
    }

    public JokeTask(TaskResponseListener taskResponseListener) {
        mListener = taskResponseListener;
    }

    @Override
    protected String doInBackground(String... params) {
        if(jokeApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
            new AndroidJsonFactory(), null)
            .setRootUrl("https://joke-app.appspot.com/_ah/api/");
            jokeApi = builder.build();
        }
        try{
            return jokeApi.joke().execute().getData();
        }
        catch(IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result){
        // if not null, this is being called from the activity
        if(mContext != null){
            Intent intent = new Intent(mContext, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE, result);
            mContext.startActivity(intent);
        }

        // for tests, if we have a listener, pass the joke
        if(mListener != null){
            mListener.onDone(result);
        }
    }

    // http://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/24149915#24149915
    // Implement interface to receive joke when AsyncTask is complete, used for test
    public interface TaskResponseListener {
        public void onDone(String joke);
    }

}