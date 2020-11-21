package com.example.recycleeproject_mobile;

public class Usercd {
    String userid;
    String usernome;
    String useremail;
    String localizacao;
    String descricao;

    public Usercd(String userid, String usernome, String useremail, String localizacao, String descricao) {
        this.userid = userid;
        this.usernome = usernome;
        this.useremail = useremail;
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsernome() {
        return usernome;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getDescricao() {
        return descricao;
    }
}
