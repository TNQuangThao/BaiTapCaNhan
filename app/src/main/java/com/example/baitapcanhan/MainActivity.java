package com.example.baitapcanhan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayout);
        viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager2=findViewById(R.id.viewPager);
        viewPager2.setAdapter(viewPagerAdapter);
        bottomNavigationView=findViewById(R.id.bottomNav);
        frameLayout=findViewById(R.id.frameLayout);;
        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                    case 1:
                    case 2:
                        tabLayout.getTabAt(position).select();
                }
                super.onPageSelected(position);
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                frameLayout.setVisibility(View.VISIBLE);
                viewPager2.setVisibility(View.GONE);
                if(item.getItemId()==R.id.menu_home){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout,new HomeFragment()).commit();
                }else if(item.getItemId()==R.id.menu_profile){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout,new ProfileFragment()).commit();
                }else if(item.getItemId()==R.id.menu_setting){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout,new SettingFragment()).commit();
                }else{
                    return false;
                }
                return true;
            }
        });
    }
}