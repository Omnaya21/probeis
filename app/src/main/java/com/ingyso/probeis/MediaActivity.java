package com.ingyso.probeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MediaActivity extends AppCompatActivity {

    // Vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        getImages();
    }

    private void getImages(){
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/israel_lopez_firma_rangers-750x455.jpg");
        mNames.add("Israel Lopez a Los Rangers");

        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/zenizo_firma_con_padres_de_san_diego_tumb-1.jpg");
        mNames.add("Zenizo firma con Padres de San Diego");

        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/jovenes_que_participaron_en_la_sip_de_probeis__fueron_firmados_por_filadelfia_tumb.jpg");
        mNames.add("Jared Loyo y Pedro Antonio Reyes, lanzadores veracruzanos");

        mImageUrls.add("https://drive.google.com/uc?id=1SWeliqZNQv8ccxBQpMzWzqtf0YbsXJAu");
        mNames.add("Firma de contrato");


        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/carlos_tarango_se_une_a_las_filas_de_el_paso_community_college_tumb_1.jpg");
        mNames.add("Carlos Tarango se une a las filas de El Paso Community College para llevar a cabo una formación integral con educación y deporte");

        mImageUrls.add("https://www.probeis.mx/wp-content/uploads/softbol_femenil_clasifica_juegos_olimpicos.jpg");
        mNames.add("La escuadra mexicana quedó invicta en el clasificatorio de las Américas rumbo a Tokio 2020");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.media_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewMediaAdapter adapter = new RecyclerViewMediaAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

}
