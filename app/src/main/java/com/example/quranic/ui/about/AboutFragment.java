package com.example.quranic.ui.about;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quranic.MainActivity;
import com.example.quranic.R;
import com.example.quranic.data.pojo.prayertimes.City;
import com.example.quranic.ui.quran.quranindex.QuranIndexPagerAdapter;
import com.example.quranic.ui.quran.quranindex.QuranIndexViewModel;
import com.example.quranic.ui.quran.quranpage.QuranPageFragment;
import com.example.quranic.ui.quran.quransearch.QuranSearchFragment;
import com.google.android.material.tabs.TabLayoutMediator;

public class AboutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);



    }

}