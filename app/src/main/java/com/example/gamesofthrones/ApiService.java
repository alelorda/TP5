package com.example.gamesofthrones;

import com.example.gamesofthrones.models.Temporada;
import com.example.gamesofthrones.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService{

    @GET("Temporada")
    Call<List<Temporada>> Get();

    @GET("Temporada/{id}")
    Call<Temporada> GetSeasonById(@Path("id") int postId);

    @POST("/Usuario")
    Call<Usuario> post(@Field("Username") String Username,
                       @Field("Pass") String Pass);

    @POST("Usuario")
    Call<Boolean> Login(@Query("Username") String Username,
                       @Query("Pass") String Pass);
}
