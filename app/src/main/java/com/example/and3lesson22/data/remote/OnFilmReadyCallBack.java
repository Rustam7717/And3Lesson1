package com.example.and3lesson22.data.remote;

import com.example.and3lesson22.data.models.Film;
import java.util.List;


    public interface OnFilmReadyCallBack {

        void success(List<Film> films);
        void onServerError();
        void failure(String msg);

    }
