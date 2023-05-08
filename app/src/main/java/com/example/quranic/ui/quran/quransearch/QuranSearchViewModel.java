package com.example.quranic.ui.quran.quransearch;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quranic.data.database.QuranDao;
import com.example.quranic.data.database.QuranDatabase;
import com.example.quranic.data.pojo.quran.Aya;

import java.util.ArrayList;

  public class QuranSearchViewModel extends AndroidViewModel {



     public QuranSearchViewModel(@NonNull Application application) {
        super(application);
    }




    public ArrayList<Aya> getSearchResult(String keyword) {

         QuranDao dao = QuranDatabase.getInstance(getApplication()).quranDao();


        return (ArrayList<Aya>) dao.getAyaBySubText(keyword);

    }
    

}