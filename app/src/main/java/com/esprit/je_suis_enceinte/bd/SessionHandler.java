package com.esprit.je_suis_enceinte.bd;

import android.content.Context;
import android.content.SharedPreferences;

import com.esprit.je_suis_enceinte.entities.User;

import java.util.Date;

public class SessionHandler {
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_EXPIRES = "expires";
    private static final String KEY_NOM = "nom";
    private static final String KEY_DATETERME = "dateterme";
    private static final String KEY_GENRE = "genreuser";
    private static final String KEY_SEXE = "sexebebe";
    private static final String KEY_EMPTY = "";

    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public SessionHandler(Context mContext) {
        this.mContext = mContext;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    /**
     * Logs in the user by saving user details and setting session
     *
     * @param email
     * @param nom
     */
    public void loginUser(String email,String nom,String dateterme, String genreuser, String sexebebe) {

        mEditor.putString(KEY_EMAIL, email);
        mEditor.putString(KEY_NOM, nom);
        mEditor.putString(KEY_DATETERME, dateterme);
        mEditor.putString(KEY_GENRE, genreuser);
        mEditor.putString(KEY_SEXE, sexebebe);

        Date date = new Date();

        //Set user session for next 7 days
        long millis = date.getTime() + (7 * 24 * 60 * 60 * 1000);
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }

    /**
     * Checks whether user is logged in
     *
     * @return
     */
    public boolean isLoggedIn() {
        Date currentDate = new Date();

        long millis = mPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */
        if (millis == 0) {
            return false;
        }
        Date expiryDate = new Date(millis);

        /* Check if session is expired by comparing
        current date and Session expiry date
        */
        return currentDate.before(expiryDate);
    }

    /**
     * Fetches and returns user details
     *
     * @return user details
     */
    public User getUserDetails() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();
        user.setEmail(mPreferences.getString(KEY_EMAIL, KEY_EMPTY));
        user.setNom(mPreferences.getString(KEY_NOM, KEY_EMPTY));
        user.setDateterme(mPreferences.getString(KEY_DATETERME, KEY_EMPTY));
        user.setGenreuser(mPreferences.getString(KEY_GENRE, KEY_EMPTY));
        user.setSexebebe(mPreferences.getString(KEY_SEXE,KEY_EMPTY));
        user.setSessionExpiryDate(new Date(mPreferences.getLong(KEY_EXPIRES, 0)));

        return user;
    }

    /**
     * Logs out user by clearing the session
     */
    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
    }
}