package com.example.quranic.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quranic.R;


public class QuranFragment extends Fragment {

    private ImageView imageView;
    private QuranViewModel quranViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        quranViewModel = new QuranViewModel();

        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.quran_page);
        int quranPage = quranViewModel.getQuranImageByPageNumber(getContext(),1);
        imageView.setImageResource(quranPage);


    }
}