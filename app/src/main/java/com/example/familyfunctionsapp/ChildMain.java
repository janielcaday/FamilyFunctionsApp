package com.example.familyfunctionsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.familyfunctionsapp.databinding.ActivityChildMainBinding;
import com.example.familyfunctionsapp.databinding.ActivityParentMainBinding;

public class ChildMain extends AppCompatActivity {

    ActivityChildMainBinding childBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        childBinding = ActivityChildMainBinding.inflate(getLayoutInflater());
        setContentView(childBinding.getRoot());

        replaceFragment(new ParentHomeFragment());


        //statement that allows the user to navigate between sections
        childBinding.childBottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.ChildHome:Home:
                    replaceFragment(new ChildHomeFragment());
                    break;
                case R.id.ChildChores:
                    replaceFragment(new ChildChoresFragment());
                    break;
                case R.id.ChildValidationCenter:
                    replaceFragment(new ChildValidationCenterFragment());
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