package com.ardananjung.catatanharian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddMode extends AppCompatActivity {
    EditText nama,keterangan,waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mode);
        nama=findViewById(R.id.edtNama);
        keterangan=findViewById(R.id.edtKeterangan);
        waktu=findViewById(R.id.edtWaktu);
    }
    public void kembali(View view) {
        Intent i = new Intent(AddMode.this, MainActivity.class);
        startActivity(i);
    }
}
