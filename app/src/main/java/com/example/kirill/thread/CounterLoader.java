package com.example.kirill.thread;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

public class CounterLoader extends AsyncTaskLoader<String> {

    public CounterLoader(@NonNull Context context) {
        super(context);
    }

    protected void onStartLoading(){
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        for (int i = 0, count = 10; i < count; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Done1";
    }

    @Override
    public void deliverResult(String data) {
        super.deliverResult(data);
    }
}

