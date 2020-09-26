package com.aelinstudios.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTime);
    }
    public  void start(View view){
        String time = editText.getText().toString();
        if(time.length()==0) {
            editText.setError("Please Enter The Time");
        }
        else{
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("key",time);
        startActivity(intent);}
    }
}