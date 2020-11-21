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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro_layout extends AppCompatActivity {

    private EditText editsenha, editemail, editendereco, editdescricao, editnome;
    private Button Cadastrabtn;
    private FirebaseAuth auth;
    private LinearLayout LayoutRecebe;
    private RadioGroup RadioG;
    private RadioButton Onaor,Osimr;
    private int sno=0;
    private DatabaseReference databaseusuario;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_layout);
        databaseusuario = FirebaseDatabase.getInstance().getReference("usuario");

        inicializarComponentes();
        eventoClicks();

        Onaor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutRecebe.setVisibility(View.GONE);
                editendereco.getText().clear();
                editdescricao.getText().clear();
                sno=0;

            }
        });

        Osimr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutRecebe.setVisibility(View.VISIBLE);
                sno=1;
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

    private void guardardados(String email, String nome, String localizacao, String descricao) {
        if(sno==0){

            Usernd usernd = new Usernd(id, nome , email);

            databaseusuario.child(id).setValue(usernd);
        }
        else if(sno==1){

            Usercd usercd = new Usercd(id, nome, email, localizacao, descricao);

            databaseusuario.child(id).setValue(usercd);

        }

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



    private void criarUser(final String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_layout.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Cadastro_layout.this, "Criado com Sucesso", Toast.LENGTH_SHORT).show();
                    id = auth.getUid();

                    String nome = editnome.getText().toString().trim();
                    String localizacao = editendereco.getText().toString().trim();
                    String descricao = editdescricao.getText().toString().trim();

                    guardardados(email, nome, localizacao, descricao);
                    Intent i = new Intent(Cadastro_layout.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Cadastro_layout.this, "Email já utilizado", Toast.LENGTH_SHORT).show();
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