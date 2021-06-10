package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.memorydao.MemoryInitializer;

public class App extends Application {

    public static MemoryInitializer memoryInitializer;
    public static Context appContext;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        memoryInitializer = new MemoryInitializer();
        try {
            memoryInitializer.prepareData();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        appContext = getApplicationContext();
    }
}
