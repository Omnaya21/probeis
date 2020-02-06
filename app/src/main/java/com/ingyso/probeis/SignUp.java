package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void goBack(View view) {
        Intent parentIntent = new Intent(getApplicationContext(), EntryActivity.class);
        startActivity(parentIntent);
        finish();
    }
}
