package com.example.quranic.data.azkarprovider;

import android.content.Context;

import com.example.quranic.data.pojo.azkar.ZekrType;

import java.io.InputStream;
import java.util.ArrayList;

public class AzkarTypesProvider {


    public static ArrayList<ZekrType> getAzkarTypes() {

                ArrayList<ZekrType> azkarTypes = new ArrayList<>();
                azkarTypes.add(new ZekrType("اذكار الصباح",-1));
                azkarTypes.add(new ZekrType("اذكار المساء ",-1));
                azkarTypes.add(new ZekrType("اذكار النوم",-1));

        return azkarTypes;
    }


}
