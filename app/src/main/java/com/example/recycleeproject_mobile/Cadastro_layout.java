package com.example.recycleeproject_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro_layout extends AppCompatActivity {

    private EditText editsenha, editemail, editendereco, editdescricao, editnome;
    private Button Cadastrabtn;
    private FirebaseAuth auth;
    private LinearLayout LayoutRecebe;
    private RadioGroup RadioG;
    private RadioButton Onaor,Osimr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_layout);
        inicializarComponentes();
        eventoClicks();

        Onaor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutRecebe.setVisibility(View.GONE);
                editendereco.getText().clear();
                editdescricao.getText().clear();

            }
        });

        Osimr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutRecebe.setVisibility(View.VISIBLE);
            }
        });

        inicializarFirebase();

    }

    private void inicializarFirebase() {

    }

    private void eventoClicks() {
            Cadastrabtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = editemail.getText().toString().trim();
                    String senha = editsenha.getText().toString().trim();
                    criarUser(email, senha);

                }
            });
    }



    private void inicializarComponentes() {
        editsenha = (EditText) findViewById(R.id.SenhaNInpunt);
        editemail = (EditText) findViewById(R.id.EmailInpunt);
        editendereco = (EditText) findViewById(R.id.EnderecoInput);
        editdescricao = (EditText) findViewById(R.id.DescricaoInput);
        editnome = (EditText) findViewById(R.id.NomeInput);

        Cadastrabtn = (Button) findViewById(R.id.Cadastro_Button);

        LayoutRecebe = (LinearLayout) findViewById(R.id.Layout_Recebe);

        RadioG = (RadioGroup)  findViewById(R.id.Radio);
        Onaor = (RadioButton) findViewById(R.id.Onão);
        Osimr = (RadioButton) findViewById(R.id.Osim);

    }



    private void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_layout.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Cadastro_layout.this, "Criado com Sucesso", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Cadastro_layout.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Cadastro_layout.this, "Erro", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }

}