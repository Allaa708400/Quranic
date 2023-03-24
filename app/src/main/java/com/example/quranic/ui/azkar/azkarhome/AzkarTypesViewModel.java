package com.example.quranic.ui.azkar.azkarhome;



import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.quranic.data.azkarprovider.AzkarProvider;

import com.example.quranic.data.pojo.azkar.ZekrType;


import java.util.HashSet;


public class AzkarTypesViewModel extends ViewModel {

    HashSet<ZekrType> getAzkarTypes(Context context){
        return AzkarProvider.getAzkarTypes(context);
    }
}
