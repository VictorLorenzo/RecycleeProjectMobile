package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CriarAnuncio_Layout extends AppCompatActivity {

    private Button pbtn;
    private Dialog mDialog;
    public String titulo,ncontato,dproduto;
    public EditText ctitulo,cncontato,cdproduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anuncio__layout);

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

                        Intent i = new Intent(CriarAnuncio_Layout.this, anuncio_layout.class);
                        Bundle parametros = new Bundle();

                        parametros.putString("chave_titulo", titulo);
                        parametros.putString("chave_contato", ncontato);
                        parametros.putString("chave_dproduto", dproduto);

                        i.putExtras(parametros);

                        startActivity(i);

                    }
                });


                        mDialog.show();

            }
        });

    }
}