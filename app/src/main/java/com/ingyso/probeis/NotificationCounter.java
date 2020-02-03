package com.ingyso.probeis;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NotificationCounter {
    private TextView notificationNumber;

    private final int MAX_NUMBER = 99;
    private int notification_number_counter = 0;

    public NotificationCounter(View view) {
        notificationNumber = view.findViewById(R.id.notificationCount);
    }

    public void increaseNumber() {
        notification_number_counter++;

        if (notification_number_counter > MAX_NUMBER) {
            Log.d("Counter", "Maximum number reached");
        }
        else {
            notificationNumber.setText(String.valueOf(notification_number_counter));
        }
    }

    public void resetNumber() {
        notification_number_counter = 0;
        notificationNumber.setText(String.valueOf(notification_number_counter));
    }
}
