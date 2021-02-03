package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferenceActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
   EditText etEmail;
   EditText etPassword;
   EditText etMobileNo;
    private final String Sp="mypref";
    private final String Email="EmailKey";
    private final String Password="PasswordKey";
    private final String MobileNo="MobileKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        etEmail=(EditText) findViewById(R.id.et_enter_mail_id);
        etPassword=(EditText) findViewById(R.id.et_enter_password);
        sharedPreferences=getSharedPreferences(Sp,MODE_PRIVATE);
        if(sharedPreferences.contains(Email))
        {
            etEmail.setText(sharedPreferences.getString(Email,""));
        }
        if(sharedPreferences.contains(Password))
        {
            etPassword.setText(sharedPreferences.getString(Password,""));
        }
        if(sharedPreferences.contains(MobileNo))
        {
            etMobileNo.setText(sharedPreferences.getString(MobileNo,""));
        }

    }
    public void Save(View view)
    {

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Email,etEmail.getText().toString());
        editor.putString(Password,etPassword.getText().toString());
        editor.putString(MobileNo,etMobileNo.getText().toString());
        editor.commit();
    }
    public void Retreive(View view)
    {
        etEmail=(EditText) findViewById(R.id.et_enter_mail_id);
        etPassword=(EditText) findViewById(R.id.et_enter_password);
        sharedPreferences=getSharedPreferences(Sp,MODE_PRIVATE);
        if(sharedPreferences.contains(Email))
        {
            etEmail.setText(sharedPreferences.getString(Email,""));
        }
        if(sharedPreferences.contains(Password))
        {
            etPassword.setText(sharedPreferences.getString(Password,""));
        }
        if(sharedPreferences.contains(MobileNo))
        {
            etMobileNo.setText(sharedPreferences.getString(MobileNo,""));
        }

    }
    public void Clear(View view)
    {
        etEmail=(EditText) findViewById(R.id.et_enter_mail_id);
        etPassword= (EditText)findViewById(R.id.et_enter_password);
        etMobileNo=(EditText)findViewById(R.id.et_enter_mobile_number);
        etEmail.setText("");
        etPassword.setText("");
        etMobileNo.setText("");
    }
}