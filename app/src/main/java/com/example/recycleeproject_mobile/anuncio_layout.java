package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class anuncio_layout extends AppCompatActivity {

    private TextView NQP,NP,D;
    private  String nomeqp,nomep,desc, numeroc, url;
    private ImageView anuncioi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_layout);

        NQP = findViewById(R.id.Nomeqp);
        NP = findViewById(R.id.NomeProduto);
        D = findViewById(R.id.descricao);
        anuncioi = findViewById(R.id.anuncioimg);

        nomeqp = getIntent().getExtras().getString("titulo");
        nomep = getIntent().getExtras().getString("titulo");
        desc = getIntent().getExtras().getString("descricao");
        numeroc = getIntent().getExtras().getString("numeroc");
        url = getIntent().getExtras().getString("url");

        NQP.setText(nomeqp);
        NP.setText(nomep);
        D.setText(desc);
        Picasso.get().load(url).into(anuncioi);
    }

}