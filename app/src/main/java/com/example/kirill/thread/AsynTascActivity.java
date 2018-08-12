package com.example.kirill.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class AsynTascActivity extends AppCompatActivity{
private CounterAsyncTask task;
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        Button buttonCreate = findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            task = new CounterAsyncTask();
            }
        });

        txt = findViewById(R.id.txt);
        Button buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               task.execute(new Object(),new Object(), new Object());
            }
        });
    }

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

            @Override
            protected void onProgressUpdate(Integer[] values) {
               txt.setText(values[0].toString());
            }

            @Override
            protected void onPostExecute(String result) {
                txt.setText(result.toString());
            }

            
        }
    }
