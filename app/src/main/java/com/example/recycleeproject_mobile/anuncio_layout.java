package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class anuncio_layout extends AppCompatActivity {

    private TextView NQP,NP,D;
    private  String nomeqp,nomep,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_layout);

        NQP = findViewById(R.id.NomeQ_produto);
        NP = findViewById(R.id.NomeProduto);
        D = findViewById(R.id.Descricao);

        Intent recebe = getIntent();

        Bundle parametros = recebe.getExtras();

        if(parametros != null){
            nomeqp = parametros.getString("chave_titulo");
            nomep = parametros.getString("chave_titulo");
            desc = parametros.getString("chave_dproduto");
        }

        NQP.setText(nomep);
        NP.setText(nomeqp);
        D.setText(desc);
    }

}