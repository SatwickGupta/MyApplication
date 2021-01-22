package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        EditText editText=(EditText)findViewById(R.id.etEnterOTP);
        Intent intent1=getIntent();
        Button b=findViewById(R.id.bConfrim);
        String a=intent1.getStringExtra("Name").toString();
        editText.setText("Your Name is"+a);
        Toast.makeText(MainActivity3.this, a, Toast.LENGTH_LONG).show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,MainActivity.class);



                startActivity(intent);
            }
        });



    }
}