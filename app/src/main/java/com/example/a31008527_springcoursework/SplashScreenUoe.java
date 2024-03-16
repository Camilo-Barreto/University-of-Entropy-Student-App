package com.example.a31008527_springcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreenUoe extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 2000;
    Animation logoAnim, ss_bottom_anim;
    ImageView logoUni;
    TextView ss_bottom_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen_uoe);

        // Adding splash screen logo animations
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        ss_bottom_anim = AnimationUtils.loadAnimation(this, R.anim.ss_bottom_animation);
        logoUni = findViewById(R.id.splash_screen_logo);
        ss_bottom_txt = findViewById(R.id.ss_bottom_txtview);
        logoUni.setAnimation(logoAnim);
        ss_bottom_txt.setAnimation(ss_bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenUoe.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}