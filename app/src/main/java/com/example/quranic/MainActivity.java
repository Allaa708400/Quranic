package com.example.quranic;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.quranic.data.prayersnotification.AzanPrayersUtil;
import com.example.quranic.databinding.ActivityMainBinding;
import com.example.quranic.ui.about.AboutFragment;
import com.example.quranic.ui.azkar.azkarhome.AzkarHomeFragment;
import com.example.quranic.ui.prayertimes.prayertimeshome.PrayerTimesFragment;
import com.example.quranic.ui.quran.quranindex.QuranIndexFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);





        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            Fragment fr = new QuranIndexFragment();
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, fr).commit();
            navigationView.setCheckedItem(R.id.nav_view);


        }

        AzanPrayersUtil.registerPrayers(this);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            String packageName = getPackageName();
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.quranIndexFragment) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).
                    replace(R.id.fragment_container, new QuranIndexFragment()).commit();

        }

        else if  (item.getItemId() == R.id.azkarHomeFragment) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).
                    replace(R.id.fragment_container, new AzkarHomeFragment()).commit();
        }


        else if  (item.getItemId() == R.id.prayerTimesFragment) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).
                    replace(R.id.fragment_container, new PrayerTimesFragment()).commit();
        }

        else if  (item.getItemId() == R.id.aboutFragment) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).
                    replace(R.id.fragment_container, new AboutFragment()).commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}








