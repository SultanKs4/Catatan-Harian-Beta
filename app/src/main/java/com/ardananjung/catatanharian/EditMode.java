package com.ardananjung.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ardananjung.catatanharian.data.Aktifitas;
import com.ardananjung.catatanharian.data.AktifitasDao;
import com.ardananjung.catatanharian.data.AppDbProvider;
import com.ardananjung.catatanharian.data.DatabaseTask;
import com.ardananjung.catatanharian.data.DatabaseTaskEventListener;
import com.ardananjung.catatanharian.data.catatanHarianDb;

public class EditMode extends AppCompatActivity {
    EditText nama,keterangan,waktu;
    private Aktifitas currentAktifitas;
    public static final String KEY_DATA = "key_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mode);
        nama=findViewById(R.id.edtNama);
        keterangan=findViewById(R.id.edtKeterangan);
        waktu=findViewById(R.id.edtWaktu);

        Aktifitas parcelableExtra = getIntent().getParcelableExtra(KEY_DATA);

        nama.setText(parcelableExtra.getNamaKegiatan().trim());
        keterangan.setText(parcelableExtra.getKeterangan());
        waktu.setText(parcelableExtra.getWaktu());
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

                // Mengambil Entity dari params
                Aktifitas aktifitas = (Aktifitas) params[0];

                // Mendapatkan DAO dari object database, dan memanggil method operasi INSERT
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

    public void onBtnDelete(View view)
    {
        this.syncData();
        AktifitasDao aktifitasDao = AppDbProvider.getInstance(this).aktifitasDao();
        aktifitasDao.delete(this.currentAktifitas);
        Toast.makeText(this, "Your data has been deleted..", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Lompati halaman sebelumnya //todo cek ini kalo force pindah
        startActivity(intent);
    }

    public void kembali(View view) {
        Intent i = new Intent(EditMode.this, MainActivity.class);
        startActivity(i);
    }

    public void updateData(View view) {
        this.syncData();
        AktifitasDao aktifitasDao = AppDbProvider.getInstance(this).aktifitasDao();
        aktifitasDao.update(this.currentAktifitas);
        Toast.makeText(this, "Your data has been updated!", Toast.LENGTH_SHORT).show();
    }
}