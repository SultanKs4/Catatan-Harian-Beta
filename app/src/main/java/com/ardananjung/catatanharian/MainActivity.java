package com.ardananjung.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ardananjung.catatanharian.adapter.AktifitasItemViewHolder;
import com.ardananjung.catatanharian.data.Aktifitas;
import com.ardananjung.catatanharian.data.AktifitasDao;
import com.ardananjung.catatanharian.data.AppDbProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AktifitasItemViewHolder.onAktifitasClickListener {
    public static final String KEY_DATA = "key_data";

    RecyclerView rvAktifitas;

    List<Aktifitas> aktifitasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAktifitas = findViewById(R.id.rvCatatamAktifitas);

        AktifitasDao aktifitasDao = AppDbProvider.getInstance(getApplicationContext()).aktifitasDao();

        aktifitasList = aktifitasDao.getAll();

        AktifitasItemViewHolder aktifitasItemViewHolder = new AktifitasItemViewHolder(aktifitasList);
        aktifitasItemViewHolder.setListener(this);

        rvAktifitas.setAdapter(aktifitasItemViewHolder);
        rvAktifitas.setLayoutManager(new LinearLayoutManager(this));
    }

    public void editMode(View view) {
        Intent i = new Intent(MainActivity.this, EditMode.class);
        startActivity(i);
    }

    public void addMode(View view) {
        Intent i = new Intent(MainActivity.this, AddMode.class);
        startActivity(i);
    }
    @Override
    public void onClick(View view, int position) {
        Aktifitas aktifitas= aktifitasList.get(position);
        // Kirim id pada item yang di klik untuk kebutuhan query
        int idAktifitas = aktifitas.getId();
        Intent i = new Intent(MainActivity.this, EditMode.class);
        i.putExtra(KEY_DATA, idAktifitas);
        startActivity(i);
    }
}
