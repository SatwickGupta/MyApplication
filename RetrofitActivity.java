package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    List<String> list = new ArrayList<String>();
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        TextView textView = (TextView) findViewById(R.id.ChooseCategory);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://saurav.tech/NewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
        Call<Model> call = jsonPlaceholderAPI.getPosts();


        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Model posts = response.body();
                for (Post post : posts.sources) {
                    if (!list.contains(post.getcategory())) {
                        list.add(post.getcategory());
                    }
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {


            }
        });



        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=list.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        Toast.makeText(this, "Sawick", Toast.LENGTH_SHORT).show();
        Button button=findViewById(R.id.GO);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RetrofitActivity.this, ProgrammingRecyclerview.class);
                intent.putExtra("CategorySelected",name);
                startActivity(intent);
            }
        });

    }



}