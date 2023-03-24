package com.example.quranic.ui.quran.soralist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quranic.data.database.QuranDao;
import com.example.quranic.data.database.QuranDatabase;
import com.example.quranic.data.pojo.quran.Jozz;
import com.example.quranic.data.pojo.quran.Sora;
import com.example.quranic.data.utils.IndexTabsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SoraListViewModel extends AndroidViewModel {

    public SoraListViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Sora> getAllSoras() {
        QuranDao dao = QuranDatabase.getInstance(getApplication()).quranDao();
        ArrayList<Sora> soras = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(dao.getSoraByNumber(i));
        }
        return soras;
    }

    public ArrayList<Jozz> getAllAjzaa() {

        QuranDao dao = QuranDatabase.getInstance(getApplication()).quranDao();

        ArrayList<Jozz> ajzaa = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            ajzaa.add(dao.getJozzByNumber(i));
        }
        return ajzaa;
    }



    public List<Integer> getPages() {
        return IntStream.range(1, 604).boxed().collect(Collectors.toList());
    }

    public List<?> provideIndexList(@NonNull IndexTabsUtils.QuranTabs currentTab) {
        switch (currentTab) {
            case SORA:
                return getAllSoras();

            case JOZZ:
                return getAllAjzaa();
            case PAGE:
                return getPages();
            default:
                return null;
        }
    }



}


