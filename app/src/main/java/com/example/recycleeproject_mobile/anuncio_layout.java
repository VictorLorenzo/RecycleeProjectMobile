package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class anuncio_layout extends AppCompatActivity {

    private TextView NQP,NP,D;
    private  String nomeqp,nomep,desc, numeroc, url;
    private ImageView anuncioi;
    private Button entrarcontato;
    public Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_layout);

        NQP = findViewById(R.id.Nomeqp);
        NP = findViewById(R.id.NomeProduto);
        D = findViewById(R.id.descricaot);
        anuncioi = findViewById(R.id.anuncioimg);
        entrarcontato = findViewById(R.id.Entrar_Contato);

        entrarcont();

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

    private void entrarcont() {
        mDialog = new Dialog(this);
        entrarcontato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout precisamos;
                TextView numero;
                mDialog.setContentView(R.layout.entrar_contato);

                precisamos = (LinearLayout) mDialog.findViewById(R.id.Contato_n);
                numero = (TextView) mDialog.findViewById(R.id.Numero);
                numero.setText(numeroc);

                precisamos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "https://api.whatsapp.com/send?phone=5592" + numeroc;
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });


                mDialog.show();
            }
        });
    }

}