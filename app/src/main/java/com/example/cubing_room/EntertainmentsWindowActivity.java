package com.example.cubing_room;

import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EntertainmentsWindowActivity extends AppCompatActivity {

    private ImageButton returnToMainWindowButton;
    private Button openPatternsWindowButton;
    private Button openTimerWindowButton;
    private Button openBattleWindowButton;
    private Button openPicturesWindowButton;
    private Button openControllerWindowButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainments_window);

        returnToMainWindowButton = findViewById(R.id.return_to_main_window_button);
        openPatternsWindowButton = findViewById(R.id.open_patterns_window_button);
        openTimerWindowButton = findViewById(R.id.open_timer_window_button);
        openBattleWindowButton = findViewById(R.id.open_battle_window_button);
        openPicturesWindowButton = findViewById(R.id.open_pictures_window_button);
        openControllerWindowButton = findViewById(R.id.open_controller_window_button);

        setListeners();
    }

    private void setListeners(){
        returnToMainWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntertainmentsWindowActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        openPatternsWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentsWindowActivity.this, "Узоры", Toast.LENGTH_SHORT).show();
            }
        });

        openTimerWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentsWindowActivity.this, "Таймер", Toast.LENGTH_SHORT).show();
            }
        });

        openBattleWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentsWindowActivity.this, "Сборки на скорость", Toast.LENGTH_SHORT).show();
            }
        });

        openPicturesWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentsWindowActivity.this, "Картины", Toast.LENGTH_SHORT).show();
            }
        });

        openControllerWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentsWindowActivity.this, "Пульт", Toast.LENGTH_SHORT).show();
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
