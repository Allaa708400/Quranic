package com.example.quranic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quranic.data.database.QuranDatabase;
import com.example.quranic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        QuranDatabase.getInstance(this).quranDao().getAyaByPage(1);

    }
}