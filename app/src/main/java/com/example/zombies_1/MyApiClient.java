package com.example.zombies_1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiClient {
    // Reemplaza BASE_URL con la URL base de tu API
    private static final String BASE_URL = "http://www.salomesombies.store/api/";

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
