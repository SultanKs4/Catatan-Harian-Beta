package com.ardananjung.catatanharian.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Aktifitas.class},version=1,exportSchema = false)
public abstract class catatanHarianDb extends RoomDatabase {
    public abstract AktifitasDao aktifitasDao();
}
