package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {

    Button increaseBtn, resetBtn;
    NotificationCounter notificationCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        increaseBtn = findViewById(R.id.increase);
        resetBtn = findViewById(R.id.reset);
        notificationCounter = new NotificationCounter(findViewById(R.id.bell));

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationCounter.increaseNumber();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationCounter.resetNumber();
            }
        });
    }
}
