package com.example.viklevin.clalit;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by viklevin on 05/04/2017.
 */

public class App extends Application {

    private static SharedPreferences sharedPreferences;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        context = getApplicationContext();
         updateLocal( Preference.getInstace().getLocal() );
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static void updateLocal(String local){

        Locale locale = new Locale(local);
        locale.setDefault(locale);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);

    }
}