package com.example.recycleeproject_mobile;

public class anuncio {
    String Titulo;
    String NumeroContato;
    String Descricao;

    public anuncio(String titulo, String numeroContato, String descricao) {
        Titulo = titulo;
        NumeroContato = numeroContato;
        Descricao = descricao;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getNumeroContato() {
        return NumeroContato;
    }

    public String getDescricao() {
        return Descricao;
    }
}
