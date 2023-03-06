package com.example.quranic.ui.quran.soralist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quranic.R;
import com.example.quranic.data.database.QuranDao;
import com.example.quranic.data.utils.IndexTabsUtils;


public class SoraListFragment extends Fragment {

    private RecyclerView soraList;
    private SoraListViewModel viewModel;
    private IndexTabsUtils.QuranTabs currentTab;


    public SoraListFragment(IndexTabsUtils.QuranTabs currentTab) {
        this.currentTab = currentTab;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sora_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new SoraListViewModel();

        soraList = view.findViewById(R.id.sora_list);

        soraList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        soraList.setAdapter(new SoraListAdapter(viewModel.getAllSoras(getContext()),this));

    }
}