package com.ingyso.probeis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainPlayerActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;
    Button btnGuide;
    Animation mainScreenAnimation;
    ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_player);
        setupBottomAppBar();

        mainScreenAnimation = AnimationUtils.loadAnimation(this, R.anim.main_screen_animation);

        mainImage = findViewById(R.id.mainImage);
        btnGuide = findViewById(R.id.btnguide);

        // Start the animation here
        mainImage.startAnimation(mainScreenAnimation);
        btnGuide.startAnimation(mainScreenAnimation);


        /*
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        bottomAppBar.replaceMenu(R.menu.bottom_nav_menu);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_logout:
                        Toast.makeText(MainPlayerActivity.this, "Logout from menu clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         */

        //click event over FAB
        findViewById(R.id.fab_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainPlayerActivity.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Inflate menu to bottom bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Toast.makeText(MainPlayerActivity.this, "Logout selected",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * set up Bottom Bar
     */
    private void setupBottomAppBar() {
        //find id
        bottomAppBar = findViewById(R.id.bottom_app_bar);

        //set bottom bar to Action bar as it is similar like Toolbar
        //setSupportActionBar(bottomAppBar);

        bottomAppBar.replaceMenu(R.menu.bottom_nav_menu);
        //click event over Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_logout:
                        Toast.makeText(MainPlayerActivity.this, "Logout selected",
                                Toast.LENGTH_SHORT).show();

                        // Antes de ir a la pantalla de Login es necesario preguntar si esta seguro de salir
                        // de la aplicacion
                        alertDialog("Desea salir de la aplicacion?", "Salir", "Si", "Cancelar");

                        //open login activity
                        //Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                        //startActivity(loginActivity);
                        //finish();
                        return true;

                    case R.id.action_events:
                        // User chose the "Favorite" action, mark the current item
                        // as a favorite...
                        Toast.makeText(MainPlayerActivity.this, "Events selected",
                                Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_metrics:
                        Toast.makeText(MainPlayerActivity.this, "Metrics selected",
                                Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_pictures:
                        Toast.makeText(MainPlayerActivity.this, "Pictures selected",
                                Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });

        //click event over navigation menu like back arrow or hamburger icon
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open bottom sheet
                //BottomSheetDialogFragment bottomSheetDialogFragment = BottomSheetNavigationFragment.newInstance();
                //bottomSheetDialogFragment.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
            }
        });
    }

    private void alertDialog(String message, String title, String okButtonText, String cancelButtonText) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setTitle(title);
        dialog.setPositiveButton(okButtonText,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //open login activity
                        Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(loginActivity);
                        finish();
                    }
                });
        dialog.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}
