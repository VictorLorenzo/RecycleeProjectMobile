package com.example.recycleeproject_mobile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewTitulo;
    ImageView i1;

    public MyViewHolder(@NonNull View itemView) {


        super(itemView);

        textViewTitulo=itemView.findViewById(R.id.Titulo);
        i1 = itemView.findViewById(R.id.ImagemPC1);
    }
}
