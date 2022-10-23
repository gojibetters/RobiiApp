package com.tauaferreira.robiitcc.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LevelOne.OneActivity;
import com.tauaferreira.robiitcc.databinding.ActivityLessonListBinding;
import com.tauaferreira.robiitcc.fragments.HomeFragment;
import com.tauaferreira.robiitcc.fragments.ProfileFragment;

public class LessonListActivity extends AppCompatActivity {

    private ActivityLessonListBinding mBinding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLessonListBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        replaceFragment(new HomeFragment());

        mBinding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.menu_home:
                    replaceFragment(new HomeFragment());

                    break;
                case R.id.menu_profile:
                    Fragment profile = new ProfileFragment();
                    replaceFragment(profile);
                    break;
                    }
            return true;

        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        mFragmentTransaction.commit();

    }



}