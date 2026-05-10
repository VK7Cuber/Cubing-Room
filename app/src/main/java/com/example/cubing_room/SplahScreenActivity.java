package com.example.cubing_room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplahScreenActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView initializationStepMessageView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_1);

        progressBar = findViewById(R.id.appLoadingProgressBar);
        initializationStepMessageView = findViewById(R.id.initialization_step_message);
        handler = new Handler(Looper.getMainLooper());

        initializeApp();
    }

    private void delay(long millis){
        try{
            Thread.sleep(millis);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateProgressBar(int startProgress, int endProgress){
        for (int i = startProgress; i < endProgress + 1; i++){
            delay(15);
            int current_progress = i;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(current_progress);
                }
            });
        }
    }

    private void updateInitializationMessage(String message){
        handler.post(new Runnable() {
            @Override
            public void run() {
                initializationStepMessageView.setText(message);
            }
        });
    }


    private void initializeApp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateInitializationMessage("Запускаем приложение...");
                updateProgressBar(0, 30);
                updateInitializationMessage("Инициализируем решатель кубика...");
                delay(600);
                RubiksCube.getInstance().initSolver();
                updateProgressBar(30, 60);
                updateInitializationMessage("Тестируем алгоритмы...");
                delay(600);
                RubiksCube.getInstance().testSolver();
                updateProgressBar(60, 90);
                updateInitializationMessage("Проверяем скрамблер...");
                delay(600);
                RubiksCube.getInstance().generateScramble();
                updateProgressBar(90, 100);
                updateInitializationMessage("Готово!");
                delay(600);

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
