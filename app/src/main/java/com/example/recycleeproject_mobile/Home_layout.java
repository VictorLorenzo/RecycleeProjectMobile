package com.example.recycleeproject_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Home_layout extends AppCompatActivity {

    public LinearLayout V7,V8,V9;
    public LinearLayout sidebar;
    public Dialog mDialog;
    public EditText Pesquisar;

    public int nl=0, f=0;
    public String id;

    public FirebaseRecyclerOptions<anuncio> options, options2;
    public FirebaseRecyclerAdapter<anuncio, MyViewHolder> adapter, adapter2;
    public RecyclerView recyclerView, recyclerView2;
    public DatabaseReference databaseReference, databaseReference2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        Pesquisar = findViewById(R.id.PesquisarInput);

        V7 = findViewById(R.id.LayoutLocalidades1);
        V8 = findViewById(R.id.LayouLocalidades2);
        V9 = findViewById(R.id.LayouLocalidades3);
        mudartela();

        SharedPreferences preffs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        id = preffs.getString("id", "não encontrado");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("anuncio");
        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("usuario").child(id).child("anuncios");

        mostrasidebar();



        Pesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                f=1;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString()!=null){
                    recyclerlixotela(s.toString());
                    f=1;
                } else {
                    f=0;
                }
            }
        });

        if(f!=1){
            recyclerlixotela("");
        }

        recyclerlixomeus();
    }

    private void mudartela() {
        V7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nl=0;
                Intent i = new Intent(Home_layout.this, Localidades.class);
                i.putExtra("local", nl);
                startActivity(i);
            }
        });
        V8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nl=1;
                Intent i = new Intent(Home_layout.this, Localidades.class);
                i.putExtra("local", nl);
                startActivity(i);
            }
        });
        V9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nl=2;
                Intent i = new Intent(Home_layout.this, Localidades.class);
                i.putExtra("local", nl);
                startActivity(i);
            }
        });

    }

    private void recyclerlixomeus() {
        recyclerView2 = findViewById(R.id.RecyclerMeus);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        options2= new  FirebaseRecyclerOptions.Builder<anuncio>().setQuery(databaseReference2, anuncio.class).build();
        adapter2= new FirebaseRecyclerAdapter<anuncio, MyViewHolder>(options2) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final anuncio model) {
                holder.textViewTitulo.setText(""+ model.getTitulo());

                Picasso.get().load(model.getUrl()).into(holder.i1);

                holder.i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), meus_anuncios.class);
                        intent.putExtra("titulo", model.getTitulo());
                        intent.putExtra("numeroc", model.getNumeroContato());
                        intent.putExtra("descricao", model.getDescricao());
                        intent.putExtra("url", model.getUrl());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.barradeslizantelayout, parent, false);
                return new MyViewHolder(v);
            }
        };

        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter2.startListening();
        recyclerView2.setAdapter(adapter2);

    }

    private void recyclerlixotela(String data) {
        Query query = databaseReference.orderByChild("titulo").startAt(data).endAt(data+"\uf8ff");

        recyclerView = findViewById(R.id.RecyclerLixo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (f==1){
            options=new FirebaseRecyclerOptions.Builder<anuncio>().setQuery(query, anuncio.class).build();
        }else if(f==0){
            options=new FirebaseRecyclerOptions.Builder<anuncio>().setQuery(databaseReference, anuncio.class).build();
        }
        adapter=new FirebaseRecyclerAdapter<anuncio, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final anuncio model) {

                holder.textViewTitulo.setText(""+model.getTitulo());
                Picasso.get().load(model.getUrl()).into(holder.i1);

                holder.i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), anuncio_layout.class);
                        intent.putExtra("titulo", model.getTitulo());
                        intent.putExtra("numeroc", model.getNumeroContato());
                        intent.putExtra("descricao", model.getDescricao());
                        intent.putExtra("url", model.getUrl());
                        startActivity(intent);

                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.barradeslizantelayout, parent, false);
                return new MyViewHolder(v);
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    private void mostrasidebar() {
        sidebar = findViewById(R.id.sidebar);
        mDialog = new Dialog(this);
        mDialog.getWindow().getAttributes().gravity = Gravity.START;

        sidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout criaranunciosidebar;
                mDialog.setContentView(R.layout.activity_dialog_sidebar);


                criaranunciosidebar = (LinearLayout) mDialog.findViewById(R.id.CriarAnuncio_sidebar);
                criaranunciosidebar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Home_layout.this, CriarAnuncio_Layout.class);
                        startActivity(i);
                    }
                });

                mDialog.show();
            }
        });
    }
}