package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        EditText editText=(EditText)findViewById(R.id.etEnterOTP);
        Intent intent1=getIntent();
        Button b=findViewById(R.id.bConfrim);
        String a=intent1.getStringExtra("Name").toString();
        editText.setText("Your Name is"+" "+a);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OTPActivity.this, CardViewActivity.class);
                startActivity(intent);
            }
        });



    }
}