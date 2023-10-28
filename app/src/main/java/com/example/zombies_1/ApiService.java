package com.example.zombies_1;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import java.util.List;

public interface ApiService {
    @GET("get_user")
    Call<List<User>> getUsers();

    @DELETE("delateApi/{id}") // Ruta para eliminar
    Call<Void> deleteUser(@Path("id") int userId);

    @FormUrlEncoded
    @POST("login") // Ruta para la autenticación
    Call<User> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("editApi/{id}") // Ruta para editar el usuario
    Call<Void> editarUsuario(
            @Path("id") int userId,
            @Field("name") String nombre,
            @Field("email") String email,
            @Field("password") String contraseña
    );


}