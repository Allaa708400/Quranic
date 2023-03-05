package com.example.quranic.ui;
import android.content.Context;
import com.example.quranic.data.PageManger;


public class QuranViewModel {


    public int getQuranImageByPageNumber(Context context, int pageNumber) {


        return PageManger.getQuranImageByPageNumber(context,pageNumber);


    }
}
