package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainPlayerActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;
    Button btnGuide;
    Animation mainScreenAnimation;
    ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_player);

        mainScreenAnimation = AnimationUtils.loadAnimation(this, R.anim.main_screen_animation);

        mainImage = findViewById(R.id.mainImage);
        btnGuide = findViewById(R.id.btnguide);
        bottomAppBar = findViewById(R.id.bottom_app_bar);

        // Start the animation here
        mainImage.startAnimation(mainScreenAnimation);
        btnGuide.startAnimation(mainScreenAnimation);


        bottomAppBar.replaceMenu(R.menu.bottom_nav_menu);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
