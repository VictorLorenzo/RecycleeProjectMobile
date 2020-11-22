package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CriarAnuncio_Layout extends AppCompatActivity {

    private Button pbtn;
    private Dialog mDialog;
    public String titulo,ncontato,dproduto;
    public EditText ctitulo,cncontato,cdproduto;
    private DatabaseReference databaseanuncio;
    private DatabaseReference databaseanuncioh;
    public String idd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anuncio__layout);

        SharedPreferences preffs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        idd = preffs.getString("id", "não encontrado");



        databaseanuncio = FirebaseDatabase.getInstance().getReference("usuario").child(idd);
        databaseanuncioh = FirebaseDatabase.getInstance().getReference("anuncio");

        mDialog = new Dialog(this);
        pbtn = (Button) findViewById(R.id.Publicar_Button);
        ctitulo = (EditText) findViewById(R.id.titulocampo);
        cncontato = (EditText) findViewById(R.id.numerocampo);
        cdproduto = (EditText) findViewById(R.id.descricaocampo);


        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cancelar;
                Button sim;

                mDialog.setContentView(R.layout.activity_layout_dialog);
                cancelar = (TextView) mDialog.findViewById(R.id.CancelarPub);
                sim = (Button) mDialog.findViewById(R.id.Publicar_sim);

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });

                sim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        titulo = ctitulo.getText().toString().trim();
                        ncontato = cncontato.getText().toString().trim();
                        dproduto = cdproduto.getText().toString().trim();

                        guardardados(titulo, ncontato, dproduto);

                        Intent i = new Intent(CriarAnuncio_Layout.this, Home_layout.class);
                        startActivity(i);

                    }
                });
                        mDialog.show();

            }
        });



    }

    private void guardardados(String titulo, String ncontato, String dproduto) {

        anuncio anuncio = new anuncio(titulo, ncontato, dproduto);
        databaseanuncio.child("anuncios").child(titulo).setValue(anuncio);
        databaseanuncioh.child(titulo).setValue(anuncio);
    }
}