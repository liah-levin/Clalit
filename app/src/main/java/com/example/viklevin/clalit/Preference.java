package com.example.viklevin.clalit;

/**
 * Created by viklevin on 05/04/2017.
 */

public class Preference  {

    public static Preference instace;
    public static final String FIRST_LOGIN = "true";


    public static Preference getInstace() {

        if (instace == null) {
            instace = new Preference();
        }

        return instace;
    }

    public void saveLocal(String local) {

        App.getSharedPreferences().edit().putString(FIRST_LOGIN,local).commit();
    }

    public String getLocal(){
        return App.getSharedPreferences().getString(FIRST_LOGIN,"true");
    }
}
