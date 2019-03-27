package com.example.miguel.eva2_asignaturas;

public class Materia {

    private int iconMat, iconDoc,creditos;
    private String nom, docente;

    public Materia(){}

    public Materia(int iconMat, int iconDoc, int creditos, String nom, String docente) {
        this.iconMat = iconMat;
        this.iconDoc = iconDoc;
        this.creditos = creditos;
        this.nom = nom;
        this.docente = docente;
    }

    public int getIconMat() {
        return iconMat;
    }

    public void setIconMat(int iconMat) {
        this.iconMat = iconMat;
    }

    public int getIconDoc() {
        return iconDoc;
    }

    public void setIconDoc(int iconDoc) {
        this.iconDoc = iconDoc;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
}
