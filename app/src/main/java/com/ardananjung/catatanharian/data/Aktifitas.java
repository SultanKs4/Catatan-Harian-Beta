package com.ardananjung.catatanharian.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Aktifitas {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "namaKegiatan")
    public String namaKegiatan;

    @ColumnInfo(name = "keterangan")
    public String keterangan;

    @ColumnInfo(name = "waktu")
    public String waktu;


}
