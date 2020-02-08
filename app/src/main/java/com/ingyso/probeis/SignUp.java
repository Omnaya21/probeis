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
    private Spinner genderSpinner;
    private Button signUp;
    private EditText birthday;
    private String[] genderLabels;

    private Calendar calendar;
    private DatePickerDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Spinner Setup
        addListenerOnSpinnerItemSelection();

        // Calendar setup
        birthday = findViewById(R.id.birthday);

    }

    public void addListenerOnSpinnerItemSelection() {
        Resources res = getResources();
        genderLabels = res.getStringArray(R.array.gender_labels);
        genderSpinner = findViewById(R.id.gender_spinner);
        ArrayAdapter<String> genderArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.layout_spinner, genderLabels);
        genderArrayAdapter.setDropDownViewResource(R.layout.layout_spinner_dropdown);
        genderSpinner.setAdapter(genderArrayAdapter);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener: " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

        dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                birthday.setText(mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear);
            }
        }, day, month, year);
        dateDialog.show();
    }
}
