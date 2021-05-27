package com.example.a4travel.model;

import com.example.a4travel.SQL.DatabaseHelper;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private DatabaseHelper databaseHelper;
    private String hotel;
    private String passeio;
    private int idRoteiro;
    private String gastronomia;
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

    public String getPasseio(){
        return passeio;
    }

    public String getGastronomia(){
        return gastronomia;
    }

    public void setGastronomia(String gastronomia){
        this.gastronomia = gastronomia;
    }

    public void setPasseio(String passeio){
        this.passeio = passeio;
    }

    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    public String getRegiao(){
        return regiao;
    }

}
