package com.ardananjung.catatanharian.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AktifitasDao {
    @Query("SELECT * FROM Aktifitas")
    List<Aktifitas> getAll();

    @Delete
    void delete(Aktifitas aktifitas);

    @Insert
    void insertAll(Aktifitas... aktifitas);

    @Update
    void update(Aktifitas aktifitas);
}
