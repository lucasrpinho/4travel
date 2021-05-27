package com.example.a4travel.model;

public class roteiro {

    private String hotel;
    private String passeio;
    private int idRoteiro;
    private String gastronomia;
    private String regiao;

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
