package com.example.recycleeproject_mobile;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class Home_layout extends AppCompatActivity {

    private LinearLayout V1,V2,V3,V4,V5,V6,V7,V8,V9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);


        V1 = findViewById(R.id.View1);
        V2 = findViewById(R.id.View2);
        V3 = findViewById(R.id.View3);
        V4 = findViewById(R.id.View4);
        V5 = findViewById(R.id.View5);
        V6 = findViewById(R.id.View6);
        V7 = findViewById(R.id.View7);
        V8 = findViewById(R.id.View8);
        V9 = findViewById(R.id.View9);

        V1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, CriarAnuncio_Layout.class);
                startActivity(i);
            }
        });

        V2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, anuncio_layout.class);
                startActivity(i);
            }
        });
        V3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, anuncio_layout.class);
                startActivity(i);
            }
        });
        V4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, meus_anuncios.class);
                startActivity(i);
            }
        });
        V5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, meus_anuncios.class);
                startActivity(i);
            }
        });
        V6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, meus_anuncios.class);
                startActivity(i);
            }
        });

        V7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
                startActivity(i);
            }
        });

        V8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
                startActivity(i);
            }
        });

        V9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
                startActivity(i);
            }
        });

    }
}