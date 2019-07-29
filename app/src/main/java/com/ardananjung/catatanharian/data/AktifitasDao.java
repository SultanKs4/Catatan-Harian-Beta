package com.ardananjung.catatanharian.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AktifitasDao {
    @Query("SELECT * FROM Aktifitas")
    List<Aktifitas> getAll();

    @Delete
    void delete(Aktifitas aktifitas);
}
