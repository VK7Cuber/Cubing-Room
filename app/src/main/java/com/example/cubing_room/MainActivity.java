package com.example.cubing_room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton settingsButton;
    private Button solvingButton;
    private Button scrambleButton;
    private Button workingWithCubeButton;
    private Button workingWithRobotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsButton = findViewById(R.id.settings_button);
        solvingButton = findViewById(R.id.solving_button);
        scrambleButton = findViewById(R.id.scramble_button);
        workingWithCubeButton = findViewById(R.id.work_with_cube_button);
        workingWithRobotButton = findViewById(R.id.work_with_robot_button);

        setButtonListeners();
    }

    private void setButtonListeners(){
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
            }
        });

        solvingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Сбоорка", Toast.LENGTH_SHORT).show();
            }
        });

        scrambleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Скрамбл", Toast.LENGTH_SHORT).show();
            }
        });

        workingWithCubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Работа с кубиком", Toast.LENGTH_SHORT).show();
            }
        });

        workingWithRobotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Работа с роботом", Toast.LENGTH_SHORT).show();
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