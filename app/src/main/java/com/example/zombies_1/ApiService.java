package com.example.zombies_1;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("get_user")
    Call<List<User>> getUsers();
}