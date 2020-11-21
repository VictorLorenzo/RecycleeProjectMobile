package com.example.recycleeproject_mobile;

public class Usernd {

    String userid;
    String usernome;
    String useremail;

    public Usernd(){

    }

    public Usernd(String userid, String usernome, String useremail) {
        this.userid = userid;
        this.usernome = usernome;
        this.useremail = useremail;
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
}
