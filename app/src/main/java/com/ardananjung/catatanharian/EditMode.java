package com.ardananjung.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ardananjung.catatanharian.data.Aktifitas;
import com.ardananjung.catatanharian.data.DatabaseTask;
import com.ardananjung.catatanharian.data.DatabaseTaskEventListener;
import com.ardananjung.catatanharian.data.catatanHarianDb;

public class EditMode extends AppCompatActivity {
    EditText nama,keterangan,waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mode);
        nama=findViewById(R.id.edtNama);
        keterangan=findViewById(R.id.edtKeterangan);
        waktu=findViewById(R.id.edtWaktu);
    }

    private Aktifitas makeAktifitas(){
        Aktifitas a = new Aktifitas();
        a.namaKegiatan=this.nama.getText().toString();
        a.keterangan=this.keterangan.getText().toString();
        a.waktu=this.waktu.getText().toString();
    }

    public void onBtnSave(View view){
        new DatabaseTask(this, new DatabaseTaskEventListener() {

            @Override
            public Object runDatabaseOperation(RoomDatabase database, Object... params) {

                // Mengambil Entity dari params
                Aktifitas aktifitas = (Aktifitas) params[0];

                // Mendapatkan DAO dari object database, dan memanggil method operasi INSERT
                ((catatanHarianDb) database).aktifitasDao().insertAll(aktifitas);

                return null;
            }
        }).execute(this.makeAktifitas());
    }
    public void kembali(View view) {
        Intent i = new Intent(EditMode.this, MainActivity.class);
        startActivity(i);
    }
}