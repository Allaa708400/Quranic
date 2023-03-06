package com.example.quranic.ui.quran.qurancontainer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quranic.ui.quran.quranpage.QuranPageFragment;

public class QuranPagesAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 604;

    public QuranPagesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new QuranPageFragment(NUM_PAGES);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
