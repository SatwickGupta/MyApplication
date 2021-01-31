package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class AudioActivity extends AppCompatActivity {
    AudioManager audioManager;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.masterbgm);
        Button button=findViewById(R.id.btnGoToVideo);
        Button play=findViewById(R.id.btnPlay);
        Button pause=findViewById(R.id.btnPause);


        //AudioManager Related//
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
        int maxvol=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currvol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int minvol=audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC);
        //End of AudioManager Related//


        //SeekBar Related//
        SeekBar seekBar=(SeekBar)findViewById(R.id.sbVolume);
        seekBar.setProgress(currvol);
        //End of SeekBar//

        //playbutton implementation//
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        //end of playbutton implementation//


        //pause button implementation//
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        //end of pause button implementation//


        //Go to Video button implementation//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AudioActivity.this,VideoViewActivity.class);
                startActivity(intent);
            }
        });
        //End of GO to Video Button implementation//



        //Seekbar Implementation//
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}