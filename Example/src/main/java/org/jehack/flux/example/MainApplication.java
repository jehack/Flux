package org.jehack.flux.example;

import android.app.Application;

import org.jehack.flux.Flux;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Flux.getInstance().register(this);
    }
}
