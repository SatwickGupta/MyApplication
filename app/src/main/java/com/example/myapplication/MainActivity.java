package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Camera;
import android.media.CameraProfile;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {









   /*Override*/
      protected   void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Info","App Created");
        setContentView(R.layout.activity_signin);
         final EditText editText=(EditText)findViewById(R.id.etEnterNumber);
          Button b=findViewById(R.id.bSignIn);
          Toast.makeText(MainActivity.this, "Satwick", Toast.LENGTH_LONG).show();
          b.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                  String name=editText.getText().toString();
                  intent.putExtra("Name",name);
                  startActivity(intent);
              }
          });
    }
    /*Override*/
    public  void onStart(Bundle savedInstanceState) {
        super.onStart();
        Log.i("Info","App Started");


    }
    /*Override*/
    public void onResume(Bundle savedInstanceState) {
        super.onResume();
        Log.i("Info","App Resumed");
    }
    /*Override*/
    public  void onPause(Bundle savedInstanceState) {
        super.onPause();
        Log.i("Info","App Paused");
    }
    /*Override*/
    public  void onStop(Bundle savedInstanceState) {
        super.onStop();
        Log.i("Info","App Stopped");
    }
    /*Override*/
    public  void onDestroy(Bundle savedInstanceState) {
        super.onDestroy();
        Log.i("Info","App Destroyed");
    }




}