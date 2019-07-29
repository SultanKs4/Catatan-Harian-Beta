package com.ardananjung.catatanharian.data;

import android.content.Context;

import androidx.room.Room;

public class AppDbProvider {
    private static catatanHarianDb instance;
    private static catatanHarianDb asynchronousInstance;

    public static catatanHarianDb getInstance(Context context) {
        if (AppDbProvider.instance == null) {
            AppDbProvider.instance = Room.databaseBuilder(
                    context, catatanHarianDb.class, "catatanHarian.db").allowMainThreadQueries().build();
        }

        return AppDbProvider.instance;
    }

    public static catatanHarianDb getAsynchronousInstance(Context context) {
        if (AppDbProvider.asynchronousInstance == null) {
            AppDbProvider.asynchronousInstance = Room.databaseBuilder(
                    context, catatanHarianDb.class, "catatanHarian.db").build();
        }

        return AppDbProvider.asynchronousInstance;

    }
}
