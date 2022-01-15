package com.example.and3lesson22.ui.films_detail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.example.and3lesson22.App;
import com.example.and3lesson22.data.models.Film;
import com.example.and3lesson22.data.remote.OnFilmDetailCallBack;
import com.example.and3lesson22.databinding.FragmentFilmDetailBinding;


public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        Bundle bundle = getArguments();
        String id;
        if (bundle != null) {
            id = bundle.getString("Key");
            App.apiService.getDetailFilms(id, new OnFilmDetailCallBack() {
                @Override
                public void success(Film film) {
                    binding.tvDescriptionDetail.setText(film.getDescription());
//                    binding.tvFilmDetailId.setText(film.getId());
                    binding.tvDirectorDetail.setText(film.getDirector());
                    Log.e("a", "success: " + film.getDescription());
                    binding.tvTitleDetail.setText(film.getTitle());
                    binding.tvReleaseDate.setText(String.valueOf(film.getRelease_Date()));

                    Glide.with(binding.ivFilmsDetail)
                            .load(film.getImage())
                            .into(binding.ivFilmsDetail);
                }

                @Override
                public void onServerError() {
                    Log.e("Tag", "Error");
                }

                @Override
                public void Failure(String msg) {
                    Log.e("Tag", msg);

                }
            });
        }

    }

}
