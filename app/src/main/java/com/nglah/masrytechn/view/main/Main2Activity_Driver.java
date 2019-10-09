package com.nglah.masrytechn.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.drive_Profile.drive_profile;
import com.nglah.masrytechn.view.login.LoginActivity;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity_Driver extends AppCompatActivity {

    ViewModelUser viewModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__driver);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.makeLogout().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    goToLogin();
                }
            }
        });

    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.my_info)
    void goToUserProfile() {
        startActivity(new Intent(this, drive_profile.class));
    }

    @OnClick(R.id.logout)
    void logOut() {
        viewModelUser.setLogout(this);
    }
}