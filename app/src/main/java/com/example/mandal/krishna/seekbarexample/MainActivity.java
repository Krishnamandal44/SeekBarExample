package com.example.mandal.krishna.seekbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static SeekBar simple, custom;
    private static TextView seek_progress, custom_seek_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListeners();
    }
    // Initializing all views
    void init() {
        simple = (SeekBar) findViewById(R.id.simple_seekbar);
        custom = (SeekBar) findViewById(R.id.custom_seekbar);

        seek_progress = (TextView) findViewById(R.id.seek_progress);
        custom_seek_progress = (TextView) findViewById(R.id.custom_seek_progress);

        // Initially setting text to textViews
        seek_progress.setText("Progress Covered : " + simple.getProgress() // Get
                // progress
                + "/" + simple.getMax());// Get maximum progress

        custom_seek_progress.setText("Progress Covered : "
                + custom.getProgress() + "/" + custom.getMax());

    }

    // Setting listeners to both seekbars
    void setListeners() {

        simple.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Initially progress should be 0
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue,
                                          boolean fromUser) {

                // On progress changed the progress value should also change
                progress = progresValue;
                seek_progress.setText("Progress Covered : " + progress + "/"
                        + seekBar.getMax());

                Toast.makeText(getApplicationContext(),
                        "Changing seekbar's progress", Toast.LENGTH_SHORT)
                        .show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                Toast.makeText(getApplicationContext(),
                        "Started tracking seekbar", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // When tracking stops modify the textview text with progress
                // value
                seek_progress.setText("Progress Covered : " + progress + "/"
                        + seekBar.getMax());

                Toast.makeText(getApplicationContext(),
                        "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

            }

        });

        custom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue,
                                          boolean fromUser) {

                progress = progresValue;
                custom_seek_progress.setText("Progress Covered : " + progress
                        + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(),
                        "Changing seekbar's progress", Toast.LENGTH_SHORT)
                        .show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(getApplicationContext(),
                        "Started tracking seekbar", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                custom_seek_progress.setText("Progress Covered : " + progress
                        + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(),
                        "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

            }

        });

    }
}
