package com.example.quranic.ui.quran.quranindex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quranic.data.utils.IndexTabsUtils;
import com.example.quranic.ui.quran.soralist.SoraListFragment;

public class QuranIndexPagerAdapter extends FragmentStateAdapter {
    public static final int PAGES_COUNT = 3;

    public QuranIndexPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SoraListFragment(IndexTabsUtils.QuranTabs.SORA);

            case 1:
                return new SoraListFragment(IndexTabsUtils.QuranTabs.JOZZ);

            case 2:
                return new SoraListFragment(IndexTabsUtils.QuranTabs.PAGE);

            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return PAGES_COUNT;
    }
}



