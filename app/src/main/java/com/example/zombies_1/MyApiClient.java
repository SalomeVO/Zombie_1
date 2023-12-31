package com.example.zombies_1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiClient {
    private static final String BASE_URL = "http://3.133.130.232/api/";

    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            // Configura Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
