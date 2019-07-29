package com.ardananjung.catatanharian.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Aktifitas implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "namaKegiatan")
    public String namaKegiatan;

    @ColumnInfo(name = "keterangan")
    public String keterangan;

    @ColumnInfo(name = "waktu")
    public String waktu;

    public Aktifitas() {

    }

    protected Aktifitas(Parcel in) {
        id = in.readInt();
        namaKegiatan = in.readString();
        keterangan = in.readString();
        waktu = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(namaKegiatan);
        dest.writeString(keterangan);
        dest.writeString(waktu);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Aktifitas> CREATOR = new Creator<Aktifitas>() {
        @Override
        public Aktifitas createFromParcel(Parcel in) {
            return new Aktifitas(in);
        }

        @Override
        public Aktifitas[] newArray(int size) {
            return new Aktifitas[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
