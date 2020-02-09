package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignUp extends AppCompatActivity {
    private EditText birthday;

    private Calendar calendar;
    private DatePickerDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Calendar setup
        birthday = findViewById(R.id.birthday);
    }

    public void goBack(View view) {
        Intent parentIntent = new Intent(getApplicationContext(), EntryActivity.class);
        startActivity(parentIntent);
        finish();
    }

    public void selectDate(View view) {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        Toast.makeText(this, "Date: " + day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();

        dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                birthday.setText(mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear);
            }
        }, year, month, day);
        dateDialog.show();
    }
}
