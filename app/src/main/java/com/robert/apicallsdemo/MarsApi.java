package com.robert.apicallsdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MarsApi  {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);


}


