package com.example.quranic.data;
import android.annotation.SuppressLint;
import android.content.Context;
import java.text.DecimalFormat;
@SuppressLint("NewApi")

public class PageManger {



    public static int getQuranImageByPageNumber(Context context, int pageNumber) {


        DecimalFormat formatter = new DecimalFormat("000");

        String drawableName = "page" + formatter.format(pageNumber);


            return context.getResources().getIdentifier(drawableName,"drawable",context.getOpPackageName());


    }
}
