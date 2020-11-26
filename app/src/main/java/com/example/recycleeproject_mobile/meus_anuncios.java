package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class meus_anuncios extends AppCompatActivity {

    public Button Edanuncio,Exanuncio;
    public Dialog mDialog;
    private  String nomeqp,nomep,desc, url;
    private TextView NQP,NP,D;
    private ImageView anunciomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios);
        NQP = findViewById(R.id.Nomeqp);
        NP = findViewById(R.id.nomep);
        D = findViewById(R.id.descricao);
        anunciomi = findViewById(R.id.meuanuncioimg);

        colocarinfo();


        mDialog = new Dialog(this);
        Edanuncio = findViewById(R.id.Editar_Anuncio);
        Exanuncio = findViewById(R.id.Excluir_Anuncio);

        Edanuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(meus_anuncios.this, Activity_editar_anuncio.class);
                startActivity(i);
            }
        });

        Exanuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cancelar;
                mDialog.setContentView(R.layout.activity_excluir__anuncio);
                cancelar = (TextView) mDialog.findViewById(R.id.CancelarPub);
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                mDialog.show();
            }
        });
    }

    private void colocarinfo() {
        nomeqp = getIntent().getExtras().getString("titulo");
        nomep = getIntent().getExtras().getString("titulo");
        desc = getIntent().getExtras().getString("descricao");
        url = getIntent().getExtras().getString("url");


        NQP.setText(nomeqp);
        NP.setText(nomep);
        D.setText(desc);
        Picasso.get().load(url).into(anunciomi);
    }
}