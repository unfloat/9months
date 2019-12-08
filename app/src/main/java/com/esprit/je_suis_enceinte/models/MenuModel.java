package com.esprit.je_suis_enceinte.models;

import java.io.Serializable;

public class MenuModel implements Serializable {
    private String menuText;
    private String menuDrawable;

    public MenuModel(String menuText, String menuDrawable) {
        this.menuText = menuText;
        this.menuDrawable = menuDrawable;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getMenuDrawable() {
        return menuDrawable;
    }

    public void setMenuDrawable(String menuDrawable) {
        this.menuDrawable = menuDrawable;
    }
}
