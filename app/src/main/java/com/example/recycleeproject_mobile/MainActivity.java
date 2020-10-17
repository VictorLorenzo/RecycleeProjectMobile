package com.example.recycleeproject_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Usuario,Senha;
    private Button btnLogin;
    private TextView Cadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Cadastro = findViewById(R.id.Cadastrar_ID);
        Usuario = findViewById(R.id.UsuarioInput);
        Senha = findViewById(R.id.SenhaInput);
        btnLogin = findViewById(R.id.Login_Button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Cadastro_layout.class);
                startActivity(i);
            }
        });


    }

    private void doLogin() {
        String email = Usuario.getText().toString();
        String password = Senha.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startMainMenuScreen(user);
                            Intent i = new Intent(MainActivity.this, Home_layout.class);
                            startActivity(i);
                        } else {
                            String msg = "Email ou senha incorreto";
                            Toast.makeText(MainActivity.this, msg,Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            startMainMenuScreen(currentUser);
        } else {
            String msg = "Erro ao autenticar usuário";
            Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG).show();
        }

    }

    private void startMainMenuScreen(FirebaseUser firebaseUser){
        String msg = "Iniciando Tela principal do app.";
        Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG).show();
    }
}