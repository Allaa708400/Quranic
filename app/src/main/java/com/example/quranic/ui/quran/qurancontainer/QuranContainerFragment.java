package com.example.quranic.ui.quran.qurancontainer;



import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quranic.R;
import com.example.quranic.ui.quran.quranpage.QuranViewModel;


public class QuranContainerFragment extends Fragment {
QuranViewModel quranViewModel;
    private final int pageNumber;

    private ViewPager2 viewPager;

     private FragmentStateAdapter pagerAdapter;



    public QuranContainerFragment(int pageNumber) {

        this.pageNumber = pageNumber;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);


        return inflater.inflate(R.layout.fragment_quran_container, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int sora = 604-getArguments().getInt("sora");

        viewPager = view.findViewById(R.id.quran_pager);
        pagerAdapter =( new QuranPagesAdapter(getActivity()));
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(sora);


        }

    }

