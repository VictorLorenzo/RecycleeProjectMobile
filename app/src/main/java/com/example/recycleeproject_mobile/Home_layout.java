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
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home_layout extends AppCompatActivity {

    public LinearLayout V7,V8,V9;
    public String id;
    public LinearLayout sidebar;
    public Dialog mDialog;


    public FirebaseRecyclerOptions<anuncio> options, options2;
    public FirebaseRecyclerAdapter<anuncio, MyViewHolder> adapter, adapter2;
    public RecyclerView recyclerView, recyclerView2;
    public DatabaseReference databaseReference, databaseReference2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        V7 = findViewById(R.id.LayoutLocalidades1);
        V8 = findViewById(R.id.LayouLocalidades2);
        V9 = findViewById(R.id.LayouLocalidades3);
        mudartela();

        SharedPreferences preffs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        id = preffs.getString("id", "não encontrado");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("anuncio");
        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("usuario").child(id).child("anuncios");

        mostrasidebar();
        recyclerlixotela();
        recyclerlixomeus();


    }

    private void mudartela() {
        V7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
                startActivity(i);
            }
        });
        V8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
                startActivity(i);
            }
        });
        V9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_layout.this, Localidades.class);
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
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull anuncio model) {
                holder.textViewTitulo.setText(""+ model.getTitulo());

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

    private void recyclerlixotela() {
        recyclerView = findViewById(R.id.RecyclerLixo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options=new FirebaseRecyclerOptions.Builder<anuncio>().setQuery(databaseReference, anuncio.class).build();
        adapter=new FirebaseRecyclerAdapter<anuncio, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final anuncio model) {

                holder.textViewTitulo.setText(""+model.getTitulo());

                holder.i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), anuncio_layout.class);
                        intent.putExtra("titulo", model.getTitulo());
                        intent.putExtra("numeroc", model.getNumeroContato());
                        intent.putExtra("descricao", model.getDescricao());
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