package com.example.kirill.thread;

import android.os.AsyncTask;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class CounterAsyncTask  extends AsyncTask<Object, Integer, String> {
    protected String doInBackground(Object[] objs) {
        for (int i = 0, count = 10; i < count; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Done1";


    }
}
