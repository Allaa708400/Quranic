package com.example.quranic.ui.quran.soralist;

import android.content.Context;

import com.example.quranic.data.database.QuranDao;
import com.example.quranic.data.database.QuranDatabase;
import com.example.quranic.data.pojo.quran.Sora;

import java.util.ArrayList;

public class SoraListViewModel {


    public ArrayList<Sora> getAllSoras(Context context) {
        QuranDao dao = QuranDatabase.getInstance(context).quranDao();
        ArrayList<Sora> soras = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(dao.getSoraByNumber(i));
        }
        return soras;
    }
}
