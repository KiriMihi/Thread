package com.example.kirill.thread;


import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoaderActivity extends Activity implements LoaderManager.LoaderCallbacks<String> {
    private TextView txt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        txt = findViewById(R.id.txt1);
        Button btn = findViewById(R.id.buttonStart1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLoaderManager().initLoader(0, null, LoaderActivity.this);
            }
        });
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new CounterLoader(getBaseContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        txt.setText(s);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
