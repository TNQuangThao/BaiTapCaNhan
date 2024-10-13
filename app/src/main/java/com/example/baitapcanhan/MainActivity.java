package com.example.baitapcanhan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);

        // Mặc định load fragment Home
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if(item.getItemId()==R.id.menu_home){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,new HomeFragment()).commit();
                }else if(item.getItemId()==R.id.menu_profile){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,new ProfileFragment()).commit();
                }else if(item.getItemId()==R.id.menu_setting){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,new SettingFragment()).commit();
                }else{
                    return false;
                }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
}

//public class MainActivity extends AppCompatActivity {
//    TabLayout tabLayout;
//    ViewPager2 viewPagerHome;
//    HomeViewPagerAdapter viewPagerAdapter;
//    BottomNavigationView bottomNavigationView;
//    FrameLayout frameLayout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        viewPagerAdapter=new HomeViewPagerAdapter(this);
//        viewPagerHome=findViewById(R.id.viewPagerHome);
//        viewPagerHome.setAdapter(viewPagerAdapter);
//        bottomNavigationView=findViewById(R.id.bottomNav);
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if(item.getItemId()==R.id.menu_home){
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.viewPagerHome,new HomeFragment()).commit();
//                }else if(item.getItemId()==R.id.menu_profile){
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.viewPagerHome,new ProfileFragment()).commit();
//                }else if(item.getItemId()==R.id.menu_setting){
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.viewPagerHome,new SettingFragment()).commit();
//                }else{
//                    return false;
//                }
//                return true;
//            }
//        });
//    }
//}