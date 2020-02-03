package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MetricsActivity extends AppCompatActivity {

    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mDescriptions = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrics);

        getImages();
    }

    private void getImages(){
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mTitles.add("Bat Speed");
        mImageUrls.add("drawable://" + R.drawable.sample_chart);
        //mImageUrls.add("https://www.probeis.mx/wp-content/uploads/israel_lopez_firma_rangers-750x455.jpg");
        mDescriptions.add("Bat Speed");

        mTitles.add("Exit Velocity");
        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/zenizo_firma_con_padres_de_san_diego_tumb-1.jpg");
        mDescriptions.add("Exit Velocity");

        mTitles.add("HTC");
        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/jovenes_que_participaron_en_la_sip_de_probeis__fueron_firmados_por_filadelfia_tumb.jpg");
        mDescriptions.add("Home to center");

        mTitles.add("Pop Time");
        mImageUrls.add("https://drive.google.com/uc?id=1SWeliqZNQv8ccxBQpMzWzqtf0YbsXJAu");
        mDescriptions.add("Pop Time");

        mTitles.add("Fast Ball");
        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/carlos_tarango_se_une_a_las_filas_de_el_paso_community_college_tumb_1.jpg");
        mDescriptions.add("Fast ball");

        initRecyclerView();
    }

    private void initRecyclerView(){
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.metric_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewMetricAdapter adapter = new RecyclerViewMetricAdapter(this, mTitles, mDescriptions, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
