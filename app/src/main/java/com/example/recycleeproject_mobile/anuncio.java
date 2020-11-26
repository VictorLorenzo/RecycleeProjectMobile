package com.example.recycleeproject_mobile;

public class anuncio {
    String Titulo;
    String NumeroContato;
    String Descricao;
    String url;

    public anuncio() {
    }

    public anuncio(String titulo, String numeroContato, String descricao, String url) {
        Titulo = titulo;
        NumeroContato = numeroContato;
        Descricao = descricao;
        this.url = url;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getNumeroContato() {
        return NumeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        NumeroContato = numeroContato;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
