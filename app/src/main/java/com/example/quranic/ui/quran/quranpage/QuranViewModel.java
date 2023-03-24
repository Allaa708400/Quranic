package com.example.quranic.ui.quran.quranpage;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quranic.data.PagesManger;

public class QuranViewModel extends AndroidViewModel {

    public QuranViewModel(@NonNull Application application) {
        super(application);
    }

    public Drawable getQuranImageByPageNumber(int pageNumber) {

        return PagesManger.getQuranImageByPageNumber(getApplication(), pageNumber);
    }

}
