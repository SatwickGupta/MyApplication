package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        TextView textView=(TextView)findViewById(R.id.tvretrofit);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://saurav.tech/NewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI=retrofit.create(JSONPlaceholderAPI.class);
        HashSet<String> h=new HashSet<String>();
        Call<Model> call=jsonPlaceholderAPI.getPosts();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(!response.isSuccessful())
                {
                    textView.setText("code"+response.code());
                    return;
                }
                Model posts=response.body();
                for(Post post:posts.sources)
                {
                    if(post.getcategory().equals("health")){

                        list.add(post.getName());
                    }



                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                textView.setText(t.getMessage());
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.Spinner);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}