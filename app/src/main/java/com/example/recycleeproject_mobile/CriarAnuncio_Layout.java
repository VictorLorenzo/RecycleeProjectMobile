package com.example.recycleeproject_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CriarAnuncio_Layout extends AppCompatActivity {

    private Button pbtn;
    private Dialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anuncio__layout);

        mDialog = new Dialog(this);
        pbtn = (Button) findViewById(R.id.Publicar_Button);
        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cancelar;
                mDialog.setContentView(R.layout.activity_layout_dialog);
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
}