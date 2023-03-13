package com.example.quranic.ui.azkar.azkarhome;



import com.example.quranic.data.azkarprovider.AzkarTypesProvider;
import com.example.quranic.data.pojo.azkar.ZekrType;

import java.util.ArrayList;


public class AzkarTypesViewModel {

   ArrayList<ZekrType> getAzkarTypes(){

       return AzkarTypesProvider.getAzkarTypes();
    }
}
