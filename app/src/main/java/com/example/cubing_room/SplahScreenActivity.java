package com.example.cubing_room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplahScreenActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_1);

        progressBar = findViewById(R.id.appLoadingProgressBar);
        handler = new Handler(Looper.getMainLooper());

        simulateLoading();
    }

    private void simulateLoading(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    try{
                        Thread.sleep(30);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    final int progress = i;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                        }
                    });
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplahScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).start();
    }
}
