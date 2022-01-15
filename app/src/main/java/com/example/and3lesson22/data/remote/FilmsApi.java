package com.example.and3lesson22.data.remote;

import com.example.and3lesson22.data.models.Film;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("films/{id}")
    Call<Film>getDetailFilms(@Path("id") String id);
}

