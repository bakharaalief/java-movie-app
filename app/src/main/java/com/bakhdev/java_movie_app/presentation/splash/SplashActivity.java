package com.bakhdev.java_movie_app.presentation.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.bakhdev.java_movie_app.base.BaseActivity;
import com.bakhdev.java_movie_app.databinding.ActivitySplashBinding;
import com.bakhdev.java_movie_app.presentation.home.HomeActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    private static final int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toHomeActivity();
    }

    @Override
    protected ActivitySplashBinding setBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    private void toHomeActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }


}