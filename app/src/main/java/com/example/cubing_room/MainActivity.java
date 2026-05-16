package com.example.cubing_room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private ImageButton openSettingWindowButton;
    private Button openSolvingWindowButton;
    private Button openScrambleWindowButton;
    private Button openTrainingWindowButton;
    private Button openEntertainmentsWindowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // openSettingWindowButton = findViewById(R.id.open_settings_window_button);
        openSolvingWindowButton = findViewById(R.id.open_solving_window_button);
        openScrambleWindowButton = findViewById(R.id.open_scramble_window_button);
        openTrainingWindowButton = findViewById(R.id.open_training_window_button);
        openEntertainmentsWindowButton = findViewById(R.id.open_entertainments_window_button);

        setButtonListeners();
    }

    private void setButtonListeners(){
//        openSettingWindowButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
//            }
//        });

        openSolvingWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SolvingWindowActivity.class);
                startActivity(intent);
                finish();
            }
        });

        openScrambleWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrambleWindowActivity.class);
                startActivity(intent);
                finish();
            }
        });

        openTrainingWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Обучение", Toast.LENGTH_SHORT).show();
            }
        });

        openEntertainmentsWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EntertainmentsWindowActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}