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

public class SolvingWindowActivity extends AppCompatActivity {

    private ImageButton returnToMainWindowButton;
    private Button openSolvingHistoryButton;
    private Button startSolvingButton;
    private Spinner methodsOfSolvingSpinner;
    private SeekBar settingMotorsSpeedSeekBar;
    private TextView motorsSpeedLabel;

    private Integer speedOfMotors;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solving_window);

        returnToMainWindowButton = findViewById(R.id.return_to_main_window_button);
        startSolvingButton = findViewById(R.id.start_solving_button);
        openSolvingHistoryButton = findViewById(R.id.open_solving_history_button);
        methodsOfSolvingSpinner = findViewById(R.id.choosing_solving_method_spinner);
        settingMotorsSpeedSeekBar = findViewById(R.id.settingSpeedOfMotorsSeekBar);

        motorsSpeedLabel = findViewById(R.id.motors_speed_label);
        speedOfMotors = settingMotorsSpeedSeekBar.getProgress();
        motorsSpeedLabel.setText(speedOfMotors+ "%");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.solving_methods,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        methodsOfSolvingSpinner.setAdapter(adapter);

        setListeners();
    }

    private void setListeners(){
        returnToMainWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SolvingWindowActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startSolvingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SolvingWindowActivity.this, "Сборка начата", Toast.LENGTH_SHORT).show();
            }
        });

        openSolvingHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SolvingWindowActivity.this, "История сборок", Toast.LENGTH_SHORT).show();
            }
        });

        settingMotorsSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                motorsSpeedLabel.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                speedOfMotors = settingMotorsSpeedSeekBar.getProgress();
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