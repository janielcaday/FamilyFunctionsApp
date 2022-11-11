package com.example.familyfunctionsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.familyfunctionsapp.databinding.ActivityParentMainBinding;

public class ParentMain extends AppCompatActivity {

    ActivityParentMainBinding parentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        parentBinding = ActivityParentMainBinding.inflate(getLayoutInflater());
        setContentView(parentBinding.getRoot());

        replaceFragment(new ParentHomeFragment());


        //statement that allows the user to navigate between sections
        parentBinding.parentBottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.ParentHome:
                    replaceFragment(new ParentHomeFragment());
                    break;
                case R.id.ParentChoreList:
                    replaceFragment(new ParentChoresListFragment());
                    break;
                case R.id.ParentWeek:
                    replaceFragment(new ParentWeekFragment());
                    break;
                case R.id.ParentRewards:
                    replaceFragment(new ParentRewardsFragment());
                    break;
                case R.id.ParentHistory:
                    replaceFragment(new ParentHistoryFragment());
                    break;


            }

            return true;
        });
    }

    //function that does the actual switching
    private void replaceFragment(Fragment fragment){
        FragmentManager parentFragmentManager = getSupportFragmentManager();
        FragmentTransaction parentFragmentTransaction = parentFragmentManager.beginTransaction();
        parentFragmentTransaction.replace(R.id.parentFrameLayout, fragment);
        parentFragmentTransaction.commit();


    }
}