package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;

public class Localidades extends AppCompatActivity {

    private Button mapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidades);

        mapa = findViewById(R.id.EntrarBut);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Localidades.this, MapaDescarte.class);
                startActivity(i);
            }
        });

    }
}