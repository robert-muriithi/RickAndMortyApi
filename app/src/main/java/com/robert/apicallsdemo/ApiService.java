package com.robert.apicallsdemo;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

interface ApiService {
    public static final String BASE_URL= "https://api.github.com/";
    @GET("repositories")
    Call<List<DataModel>> getRepository();
}


