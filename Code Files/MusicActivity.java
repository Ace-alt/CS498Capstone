package com.example.andriod.yeswecodeproject;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int a,b,c,d,e,f,g;
    private int sound3StreamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        //Buttons
        //Back to Game Selection Button
        Button back = (Button) findViewById(R.id.backtogameSelectButton2);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), GameSelectActivity.class);
                startActivityForResult(backIntent, 0);
            }

        });


        //Testing soundPool
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        }

        a = soundPool.load(this, R.raw.a, 1);
        b = soundPool.load(this, R.raw.b, 1);
        c = soundPool.load(this, R.raw.c, 1);
        d = soundPool.load(this, R.raw.d, 1);
        e = soundPool.load(this, R.raw.e, 1);
        f = soundPool.load(this, R.raw.f, 1);
        g = soundPool.load(this, R.raw.g, 1);
    }

    //method to play sounds
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.noteA:
                soundPool.play(a, 1, 1, 0, 0, 1);
                break;
            case R.id.noteB:
                soundPool.play(b, 1, 1, 0, 0, 1);
                break;
            case R.id.noteC:
                soundPool.play(c, 1, 1, 0, 0, 1);
                break;
            case R.id.noteD:
                soundPool.play(d, 1, 1, 0, 0, 1);
                break;
            case R.id.noteE:
                soundPool.play(e, 1, 1, 0, 0, 1);
                break;
            case R.id.noteF:
                soundPool.play(f, 1, 1, 0, 0, 1);
                break;

            case R.id.noteG:
                soundPool.play(g, 1, 1, 0, 0, 1);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    }
