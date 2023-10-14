package com.example.zombies_1;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {
    @GET("get_user")
    Call<List<User>> getUsers();

    @DELETE("delateApi/{id}")
    Call<Void> deleteUser(@Path("id") int userId);
}