package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class anuncio_layout extends AppCompatActivity {

    private TextView NQP,NP,D;
    private  String nomeqp,nomep,desc, numeroc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_layout);

        NQP = findViewById(R.id.NomeQ_produto);
        NP = findViewById(R.id.NomeProduto);
        D = findViewById(R.id.Descricao);

        nomeqp = getIntent().getExtras().getString("titulo");
        nomep = getIntent().getExtras().getString("titulo");
        desc = getIntent().getExtras().getString("descricao");
        numeroc = getIntent().getExtras().getString("numeroc");

        NQP.setText(nomeqp);
        NP.setText(nomep);
        D.setText(desc);
    }

}