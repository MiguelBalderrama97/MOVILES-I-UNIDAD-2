package com.example.miguel.eva2_restaurantes;

public class Restaurante {

    private int img1;
    private String nom, desc, calle, colonia, telefono;

    public Restaurante(int img1, String nom, String desc, String calle, String colonia, String telefono) {
        this.img1 = img1;
        this.nom = nom;
        this.desc = desc;
        this.calle = calle;
        this.colonia = colonia;
        this.telefono = telefono;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
