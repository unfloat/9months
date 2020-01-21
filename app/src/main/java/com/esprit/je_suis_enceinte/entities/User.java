package com.esprit.je_suis_enceinte.entities;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String nom;
    private String email;
    private String mdp;
    private String genreuser;
    private String sexebebe;
    private String dateterme;
    private Float poids;
    Date sessionExpiryDate;
    String salt;

    public User() {
    }

    public User(String nom, String email, String mdp) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }

    public User(String nom, String email, String mdp, String dateterme) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.dateterme = dateterme;
    }

    public User(String nom, String email, String mdp, String genreuser, String sexebebe, String dateterme) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.genreuser = genreuser;
        this.sexebebe = sexebebe;
        this.dateterme = dateterme;
    }

    public User(String nom, String email, String mdp, String genreuser, String sexebebe, String dateterme, Float poids, Date sessionExpiryDate) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.genreuser = genreuser;
        this.sexebebe = sexebebe;
        this.dateterme = dateterme;
        this.poids = poids;
        this.sessionExpiryDate = sessionExpiryDate;
    }

    public User(String nom, String email, String mdp, String genreuser, String sexebebe, String dateterme, Float poids, Date sessionExpiryDate, String salt) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.genreuser = genreuser;
        this.sexebebe = sexebebe;
        this.dateterme = dateterme;
        this.poids = poids;
        this.sessionExpiryDate = sessionExpiryDate;
        this.salt = salt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getGenreuser() {
        return genreuser;
    }

    public void setGenreuser(String genreuser) {
        this.genreuser = genreuser;
    }

    public String getSexebebe() {
        return sexebebe;
    }

    public void setSexebebe(String sexebebe) {
        this.sexebebe = sexebebe;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public Date getSessionExpiryDate() {
        return sessionExpiryDate;
    }

    public void setSessionExpiryDate(Date sessionExpiryDate) {
        this.sessionExpiryDate = sessionExpiryDate;
    }

    public String getDateterme() {
        return dateterme;
    }

    public void setDateterme(String dateterme) {
        this.dateterme = dateterme;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
