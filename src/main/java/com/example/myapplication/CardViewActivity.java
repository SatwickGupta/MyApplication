package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.content.Intent.ACTION_VIEW;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Button btn=findViewById(R.id.btnYoutube);
        Button whatsapp=findViewById(R.id.btnWhatsapp);
        Button fb=findViewById(R.id.btnFaceBook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtube.com";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(ACTION_VIEW,webpage);
                startActivity(intent);

            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://whatsapp.com";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(ACTION_VIEW,webpage);
                startActivity(intent);

            }
        });
        fb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://fb.com";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
    }
}