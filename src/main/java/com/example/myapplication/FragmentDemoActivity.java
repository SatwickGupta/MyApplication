package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class FragmentDemoActivity extends AppCompatActivity {
    public  void clickfun(View view)
    {
        Fragment fragment ;
        if(view==findViewById(R.id.btn1))
        {
            fragment=new FirstFragment();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.changingframe,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.btn2))
        {
            fragment=new SecondFragment();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.changingframe,fragment);
            ft.commit();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

    }

}