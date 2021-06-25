package com.example.a4travel.model;

import com.example.a4travel.SQL.DatabaseHelper;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private DatabaseHelper databaseHelper;
    private String hotel;
    private String passeioMatinal;
    private String passeioVespertino;
    private String passeioNoturno;
    private int idRoteiro;
    private String gastronomiaMatinal;
    private String gastronomiaAlmoço;
    private String gastronomiaNoturno;
    private String regiao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdRoteiro(){
        return idRoteiro;
    }

    public void setIdRoteiro(int idRoteiro){
        this.idRoteiro = idRoteiro;
    }

    public String getHotel(){
        return hotel;
    }

    public void setHotel(String hotel){
        this.hotel = hotel;
    }

    public String getPasseioMatinal(){
        return passeioMatinal;
    }

    public String getPasseioVespertino(){
        return passeioVespertino;
    }

    public String getPasseioNoturno(){
        return passeioNoturno;
    }

    public String getGastronomiaAlmoço(){
        return gastronomiaAlmoço;
    }

    public String getGastronomiaNoturno(){
        return gastronomiaNoturno;
    }

    public String getGastronomiaMatinal(){
        return gastronomiaMatinal;
    }

    public void setGastronomiaMatinal(String gastronomiaMatinal){
        this.gastronomiaMatinal = gastronomiaMatinal;
    }

    public void setGastronomiaAlmoço(String gastronomiaAlmoço){
        this.gastronomiaAlmoço = gastronomiaAlmoço;
    }

    public void setGastronomiaNoturno(String gastronomiaNoturno){
        this.gastronomiaNoturno = gastronomiaNoturno;
    }

    public void setPasseioMatinal(String passeioMatinal){
        this.passeioMatinal = passeioMatinal;
    }

    public void setPasseioVespertino(String passeioVespertino){
        this.passeioVespertino = passeioVespertino;
    }
    public void setPasseioNoturno(String passeioNoturno){
        this.passeioNoturno = passeioNoturno;
    }

    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    public String getRegiao(){
        return regiao;
    }

}
