package com.aelinstudios.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer m1;
    TextView v1,v2;
    Button b1;
    CountDownTimer timer;

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        m1 = MediaPlayer.create(this,R.raw.beep);
        v1=findViewById(R.id.textView2);
        v2=findViewById(R.id.textView3);
        b1=findViewById(R.id.button1);

        long time= Long.parseLong(getIntent().getStringExtra("key"));

        time = time*1000;
        timer =  new CountDownTimer(time, 1000) {
            public void onTick(long miliSecUntilDone) {
                v1.setText("Time " + String.valueOf(miliSecUntilDone / 1000));


            }


            public void onFinish() {
                v2.setText("Done!!");
                m1.start();
            }
        }.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                timer.start();
            }
        });

    }


    public void back(View view){
        timer.cancel();
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
    public void stopp(View view){
        timer.cancel();
    }

    }
    //TODO: Try not to save the current state of intent when we click on restart or back button
// TODO: restart and back button working perfectly fine


