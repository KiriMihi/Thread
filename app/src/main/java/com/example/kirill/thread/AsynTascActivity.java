package com.example.kirill.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AsynTascActivity extends AppCompatActivity implements IAsyncTaskEvents {
private CounterAsyncTask task;
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        txt = findViewById(R.id.txt);
        Button buttonCreate = findViewById(R.id.buttonCreate);
        Button buttonStart = findViewById(R.id.buttonStart);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            task = new CounterAsyncTask();
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               task.execute(new Object(),new Object(), new Object());
            }
        });
    }

    @Override
    public void onPostExecute(String result) {
        txt.setText(result);
    }

    @Override
    public void onProgressUpdate(Integer num) {
        txt.setText(num);
    }
}