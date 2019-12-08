package com.esprit.je_suis_enceinte.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String base_url= "http://192.168.1.14:4000/api/";

    public static RetrofitClient  instance;
    private Retrofit retrofit;

    private RetrofitClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static  synchronized  RetrofitClient getInstance()
    {
        if (instance == null)
        {
            instance = new RetrofitClient();

        }

        return instance;
    }

    public ApiInterface getApiInterface()
    {
        return retrofit.create(ApiInterface.class);
    }

}
