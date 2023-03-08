package com.example.quranic.ui.quran.quransearch;

import android.content.Context;

import com.example.quranic.data.database.QuranDao;
import com.example.quranic.data.database.QuranDatabase;
import com.example.quranic.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchViewModel  {

    public ArrayList<Aya> getSearchResult(Context context,String keyword) {
        QuranDao dao = QuranDatabase.getInstance(context).quranDao();
        return (ArrayList<Aya>) dao.getAyaBySubText(keyword);

    }


}
