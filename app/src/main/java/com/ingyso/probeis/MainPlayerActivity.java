package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Toast.makeText(MainPlayerActivity.this, "Logout selected",
                        Toast.LENGTH_SHORT).show();
                //finish();
                return true;

            case R.id.action_events:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.action_metrics:
                return true;

            //case R.id.action_settings:
            //    return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
