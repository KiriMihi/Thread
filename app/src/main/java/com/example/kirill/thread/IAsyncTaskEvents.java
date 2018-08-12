package com.example.kirill.thread;

public interface IAsyncTaskEvents {
    void onPostExecute(String result);
    void onProgressUpdate(Integer num);

}
