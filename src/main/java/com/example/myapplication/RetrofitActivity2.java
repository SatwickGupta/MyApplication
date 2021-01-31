package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.HashSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        TextView textView=(TextView)findViewById(R.id.tvretrofit);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://saurav.tech/NewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI=retrofit.create(JSONPlaceholderAPI.class);


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
                    String a=post.getcategory();
                        if(a.equals("entertainment")) {
                            String s = "";
                            s += " id " + post.getId() + "\n";
                            s += " name " + post.getName() + "\n";
                            s+=" Category "+post.getcategory()+"\n";
                            s += " language " + post.getLanguage() + "\n";
                            s += " country " + post.getCountry() + "\n\n";
                            textView.append(s);
                        }
                        else
                        {
                            continue;
                        }



                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                textView.setText(t.getMessage());
            }
        });

    }
}