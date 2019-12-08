package com.esprit.je_suis_enceinte.models;

public class PrenomsModel {

    private String prenom;
    private boolean isFavorite;
    private boolean isMale;

    public PrenomsModel(String prenom, boolean isFavorite, boolean isMale) {
        this.prenom = prenom;
        this.isFavorite = isFavorite;
        this.isMale = isMale;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}