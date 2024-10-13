package com.example.baitapcanhan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Set;

public class HomeViewPagerAdapter extends FragmentStateAdapter {
    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0: return new HomeFragment();
           case 1: return new ProfileFragment();
           case 2: return new SettingFragment();
           default: return new HomeFragment();
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
