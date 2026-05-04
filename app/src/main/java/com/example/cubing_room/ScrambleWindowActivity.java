package com.example.cubing_room;

import android.annotation.SuppressLint;
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

public class ScrambleWindowActivity extends AppCompatActivity {

    private ImageButton returnToMainWindowButton;
    private Button generateScramblesButton;
    private Button startScrambleButton;
    private SeekBar settingMotorsSpeedSeekBar;
    private TextView motorsSpeedLabel;

    private Integer speedOfMotors;
    private RadioEditGroup radioEditGroup;

    RubiksCube cube;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scramble_window);

        returnToMainWindowButton = findViewById(R.id.return_to_main_window_button);
        startScrambleButton = findViewById(R.id.start_scramble_button);
        generateScramblesButton = findViewById(R.id.generate_scrambles_button);
        settingMotorsSpeedSeekBar = findViewById(R.id.setting_speed_of_motors_seek_bar);

        motorsSpeedLabel = findViewById(R.id.motors_speed_label);
        speedOfMotors = settingMotorsSpeedSeekBar.getProgress();
        motorsSpeedLabel.setText(speedOfMotors + "%");

        radioEditGroup = new RadioEditGroup();

        radioEditGroup.addRadioEdit(findViewById(R.id.scramble_1_radio_edit));
        radioEditGroup.addRadioEdit(findViewById(R.id.scramble_2_radio_edit));
        radioEditGroup.addRadioEdit(findViewById(R.id.scramble_3_radio_edit));
        radioEditGroup.addRadioEdit(findViewById(R.id.scramble_4_radio_edit));
        radioEditGroup.addRadioEdit(findViewById(R.id.scramble_5_radio_edit));

        cube = new RubiksCube();

        setListeners();
    }

    private void setListeners(){
        returnToMainWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrambleWindowActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startScrambleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScrambleWindowActivity.this, "Сборка начата", Toast.LENGTH_SHORT).show();
            }
        });

        generateScramblesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < radioEditGroup.getGroupSize(); i++){
                    String scramble = cube.generateScramble();
                    radioEditGroup.setText(scramble, i);
                }
            }
        });

        settingMotorsSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
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