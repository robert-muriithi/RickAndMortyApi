package com.robert.apicallsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.name);
        recyclerView = findViewById(R.id.recycler);


        RickyAndMortyApi rickyAndMortyApi = new RickyAndMortyApi();
        rickyAndMortyApi.apiService.getRepository().enqueue(new Callback<RickyMorty>() {
            @Override
            public void onResponse(Call<RickyMorty> call, Response<RickyMorty> response) {
                adapter = new RecyclerAdapter(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RickyMorty> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
            }
        });

    }
}

//Enable Internet Permission
//ApiService
/*
* Interface = function
* class = Instatiate retrofit
* */
//Model
//Recycler Row
//RecyclerAdapter
//Wire up MainActivity