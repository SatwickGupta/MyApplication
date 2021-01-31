package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class RetrofitActivity extends AppCompatActivity  {
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        TextView textView = (TextView) findViewById(R.id.ChooseCategory);

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
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {


            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        aa.notifyDataSetChanged();
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(parent.getItemAtPosition(position).toString());
                Intent intent=new Intent(RetrofitActivity.this,SignInActivity.class);

                RetrofitActivity.this.startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }




}