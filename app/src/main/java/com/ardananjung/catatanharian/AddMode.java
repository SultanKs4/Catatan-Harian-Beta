package com.ardananjung.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ardananjung.catatanharian.data.Aktifitas;
import com.ardananjung.catatanharian.data.DatabaseTask;
import com.ardananjung.catatanharian.data.DatabaseTaskEventListener;
import com.ardananjung.catatanharian.data.catatanHarianDb;

public class AddMode extends AppCompatActivity {
    EditText nama,keterangan,waktu;
    Button buttonSelesai;
    private Aktifitas currentAktifitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mode);
        nama=findViewById(R.id.edtNama);
        keterangan=findViewById(R.id.edtKeterangan);
        waktu=findViewById(R.id.edtWaktu);
        Button btn = findViewById(R.id.btnSelesai);
        btn.setEnabled(false);
    }
    private Aktifitas makeAktifitas(){
        Aktifitas a = new Aktifitas();
        a.namaKegiatan=this.nama.getText().toString();
        a.keterangan=this.keterangan.getText().toString();
        a.waktu=this.waktu.getText().toString();
        return a;
    }
    private void syncData()
    {
        this.currentAktifitas.namaKegiatan = this.nama.getText().toString();
        this.currentAktifitas.keterangan = this.keterangan.getText().toString();
        this.currentAktifitas.waktu = this.waktu.getText().toString();
    }

    public void onBtnSave(View view){
        new DatabaseTask(this, new DatabaseTaskEventListener() {

            @Override
            public Object runDatabaseOperation(RoomDatabase database, Object... params) {
                Aktifitas aktifitas = (Aktifitas) params[0];
                ((catatanHarianDb) database).aktifitasDao().insertAll(aktifitas);
                return null;
            }

            @Override
            public void onDatabaseOperationFinished(Object... results) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        }).execute(this.makeAktifitas());
    }

    public void kembali(View view) {
        Intent i = new Intent(AddMode.this, MainActivity.class);
        startActivity(i);
    }
}