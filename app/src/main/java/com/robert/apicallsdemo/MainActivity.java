package com.robert.apicallsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

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


        MarsApi marsApi = new MarsApi();
        marsApi.apiService.getRepository().enqueue(new Callback<List<DataModel>>(){

            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                adapter = new RecyclerAdapter(response.body());
                Log.d(TAG, "onResponse: "+response.body().size());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                textView.setText(t.getLocalizedMessage());
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