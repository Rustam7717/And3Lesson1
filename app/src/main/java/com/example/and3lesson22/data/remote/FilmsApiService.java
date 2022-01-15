package com.example.and3lesson22.data.remote;

import android.util.Log;

import com.example.and3lesson22.App;
import com.example.and3lesson22.data.models.Film;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiService {


    public void getFilms(OnFilmReadyCallBack myCallBack) {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e("tag", "error");
                    myCallBack.success(response.body());
                } else if (response.code() > 500) {
                    myCallBack.onServerError();
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                myCallBack.failure(t.getLocalizedMessage());

            }
        });
    }

    public void getDetailFilms(String id, OnFilmDetailCallBack myDetailCallBack) {
        App.api.getDetailFilms(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful()) {
                    myDetailCallBack.success(response.body());
                } else if (response.code() > 500) {
                    myDetailCallBack.onServerError();
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                myDetailCallBack.Failure(t.getLocalizedMessage());

            }
        });
    }
}



