package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

public class EventsActivity extends AppCompatActivity {
    // Vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDescriptions = new ArrayList<>();
    private ArrayList<Calendar> mDates = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mMapUrls = new ArrayList<>();
    private ArrayList<String> mQrUrls = new ArrayList<>();
    private ArrayList<Boolean> mRegistered = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getEvents();
    }

    private void getEvents()
    {
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNames.add("Tijuana");
        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/israel_lopez_firma_rangers-750x455.jpg");
        mDescriptions.add("Identificacion de talento en estadio Chevron");
        mDates.add(Calendar.getInstance());
        //mMapUrls.add("https://www.google.com.mx/url?sa=i&url=https%3A%2F%2Fwww.ydesignservices.com%2Fproduct%2Ffree-wordpress-plugins%2Fmultiple-location-google-map%2F&psig=AOvVaw1WzhbWiddWEQ4Og-Gny9u8&ust=1582190726341000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNCUh_il3ecCFQAAAAAdAAAAABAU");
        //mQrUrls.add("https://www.google.com.mx/imgres?imgurl=x-raw-image%3A%2F%2F%2Ff7bc8f6d73b1bc528c72b07e87af3d37c0cc8c8962691b4f62d4395a68ac8a6a&imgrefurl=https%3A%2F%2Fqrcoderw.com%2F&tbnid=Uryxc22PvPcztM&vet=12ahUKEwjpqbyQpd3nAhWSBDQIHSOrBzkQMygFegUIARDBAQ..i&docid=GTh5VOwr2mhXLM&w=600&h=600&q=qr&hl=en&ved=2ahUKEwjpqbyQpd3nAhWSBDQIHSOrBzkQMygFegUIARDBAQ");
        //mRegistered.add(true);

        initRecyclerView();
    }

    private void initRecyclerView(){
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.events_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewEventAdapter adapter = new RecyclerViewEventAdapter(this, mNames, mDescriptions,
                mImageUrls, mDates, mMapUrls, mQrUrls, mRegistered);
        recyclerView.setAdapter(adapter);
    }
}
