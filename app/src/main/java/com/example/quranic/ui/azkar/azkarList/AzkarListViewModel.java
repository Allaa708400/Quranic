package com.example.quranic.ui.azkar.azkarList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quranic.data.azkarprovider.AzkarProvider;
import com.example.quranic.data.pojo.azkar.Zekr;

import java.util.ArrayList;

public class AzkarListViewModel extends AndroidViewModel {

    public AzkarListViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Zekr> getAzkar(String zekerType) {
        return AzkarProvider.getAzkarByType(getApplication(), zekerType);
    }
}
