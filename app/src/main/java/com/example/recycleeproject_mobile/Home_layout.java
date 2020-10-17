package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_layout extends AppCompatActivity {

    private ConstraintLayout MeusAnuncios_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        MeusAnuncios_Layout = (ConstraintLayout) findViewById(R.id.MeusAnuncios_Layout);

        MeusAnuncios_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home_layout.this, anuncio_layout.class));

            }

        });
    }
}