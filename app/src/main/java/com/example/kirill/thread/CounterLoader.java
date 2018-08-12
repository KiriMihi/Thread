package com.example.kirill.thread;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.concurrent.TimeUnit;

public class CounterLoader extends AsyncTaskLoader<String> {

    public CounterLoader(@NonNull Context context) {
        super(context);
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

