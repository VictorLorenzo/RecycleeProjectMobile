package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

public class Localidades extends AppCompatActivity {

    private Button mapa;
    private TextView nome,desc,end;
    private ImageView imagem;
    private int nl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidades);

        mapa = findViewById(R.id.EntrarBut);
        nome = findViewById(R.id.NomeLocal);
        desc = findViewById(R.id.descricaot);
        end = findViewById(R.id.enderecot);
        imagem = findViewById(R.id.ImagemLocal);
        nl = getIntent().getExtras().getInt("local");

        if(nl==1){
            nome.setText("Recicla Manaus");
            desc.setText("RECICLA MANAUS é baseada em laços de cooperação e solidariedade, tem por objetivo principal o desenvolvimento de trabalhos com reciclagem, a fim de promover efetivamente a melhoria sócio econômica dos trabalhadores na atividade de coleta do material reciclável e re-aproveitável (orgânicos e inorgânicos).");
            end.setText("Avenida Lourenço da Silva Braga, Manaus Moderna - Centro.");
            Drawable drawable = getResources().getDrawable(R.drawable.recicla_manaus);
            imagem.setImageDrawable(drawable);
        } else if(nl==2){
            nome.setText("ECO RECICLA.");
            desc.setText("Rede de Catadores e Reciclagem Solidária Eco-Recicla");
            end.setText("Rua Abel Salazar, 47 - Distrito II");
            Drawable drawable = getResources().getDrawable(R.drawable.eco_recicla);
            imagem.setImageDrawable(drawable);
        }



        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Localidades.this, MapaDescarte.class);
                startActivity(i);
            }
        });

    }
}