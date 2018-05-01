package br.com.example.mobile.helptaskapp;

import android.app.Application;
import android.content.Context;

public class Main extends Application {
    private static Main app;

    @Override
    public void onCreate(){
        super.onCreate();
        app = this;
    }

    public static Context getContext(){
        return app.getBaseContext();
    }
}
