package com.example.quranic.ui.quran.quranpage;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.quranic.data.PageManger;


public class QuranViewModel {


    public Drawable getQuranImageByPageNumber(Context context, int pageNumber) {


        return PageManger.getQuranImageByPageNumber(context,pageNumber);


    }
}
