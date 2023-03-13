package com.example.quranic;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

import com.example.quranic.databinding.ActivityMainBinding;
import com.example.quranic.ui.azkar.azkarhome.AzkarHomeFragment;
import com.example.quranic.ui.quran.qurancontainer.QuranContainerFragment;
import com.example.quranic.ui.quran.quranindex.QuranIndexFragment;
import com.example.quranic.ui.quran.quransearch.QuranSearchFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
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



        if (savedInstanceState==null) {
            Fragment fr = new QuranIndexFragment();
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, fr).commit();
            navigationView.setCheckedItem(R.id.nav_view);


        }

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

  @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

      if (item.getItemId() == R.id.azkarHomeFragment) {
          getSupportFragmentManager().beginTransaction().
                  replace(R.id.fragment_container, new AzkarHomeFragment()).commit();


      }
      drawer.closeDrawer(GravityCompat.START);
      return true;

  }
}

