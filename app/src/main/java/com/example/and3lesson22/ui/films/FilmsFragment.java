package com.example.and3lesson22.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and3lesson22.App;
import com.example.and3lesson22.R;
import com.example.and3lesson22.data.models.Film;
import com.example.and3lesson22.data.remote.OnFilmReadyCallBack;
import com.example.and3lesson22.databinding.FragmentFilmsBinding;
import com.example.and3lesson22.utils.OnItemClick;

import java.util.List;


public class FilmsFragment extends Fragment {


    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        adapter = new FilmsAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        getData();
        sendDataId();


    }

    private void setupRecyclerView() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycler.setAdapter(adapter);

    }

    private void getData() {

        App.apiService.getFilms(new OnFilmReadyCallBack() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void onServerError() {
                Log.e("TAG", "onServerError");
            }


            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure" + msg);

            }
        });

    }

    private void sendDataId() {
        adapter.setOnItemClick(new OnItemClick() {
            @Override
            public void itemClick(String position) {
                Bundle bundle = new Bundle();
                bundle.putString("Key", position);
                Navigation.findNavController(requireView()).navigate(R.id.action_filmsFragment_to_filmDetailFragment
                        , bundle);
                Log.e("tag", position);

            }
        });
    }

}
