package com.example.quranic.ui.quran.qurancontainer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quranic.R;



public class QuranContainerFragment extends Fragment {




    private ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;

    public QuranContainerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_quran_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        super.onViewCreated(view, savedInstanceState);
        Integer sora = 604;
        if(getArguments() != null){
            sora = getArguments().getInt("sora");
    }

        viewPager = view.findViewById(R.id.quran_pager);
        pagerAdapter = new QuranPagesAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(sora);

    }


}