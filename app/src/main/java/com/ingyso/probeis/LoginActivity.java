package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ingyso.probeis.R;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private TextView usernameText;
    private TextView passwordtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);
        usernameText = findViewById(R.id.username);
        passwordtext = findViewById(R.id.password);

        //---------------- OnClickListeners ---------------------
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, usernameText.getText() + ", " + passwordtext.getText(),
                        Toast.LENGTH_SHORT).show();
                // Si el usuario es para captura de metricas, mostramos la pantalla de captura de metricas.
                if (usernameText.getText().toString().equals("captura") &&
                    passwordtext.getText().toString().equals("captura")) {

                    //open capture activity
                    Intent captureActivity = new Intent(getApplicationContext(), CaptureActivity.class);
                    startActivity(captureActivity);

                    finish();
                }
                else if (usernameText.getText().toString().equals("demo") &&
                        passwordtext.getText().toString().equals("demo")) {

                    //open player activity
                    Intent playerActivity = new Intent(getApplicationContext(), MainPlayerActivity.class);
                    startActivity(playerActivity);
                    finish();
                }

            }
        });
    }
}
