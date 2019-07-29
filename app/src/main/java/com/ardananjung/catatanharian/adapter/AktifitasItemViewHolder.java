package com.ardananjung.catatanharian.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ardananjung.catatanharian.R;

public class AktifitasItemViewHolder extends RecyclerView.ViewHolder{
    private TextView txvNama,txvKeterangan,txvWaktu;

    public AktifitasItemViewHolder(@NonNull View itemView){
        super(itemView);

        this.txvNama=itemView.findViewById(R.id.namaKegiatan);
        this.txvKeterangan=itemView.findViewById(R.id.keteranganKegiatan);
        this.txvWaktu=itemView.findViewById(R.id.waktuKegiatan);
    }

    public TextView getTxvNama() {
        return txvNama;
    }

    public TextView getTxvKeterangan() {
        return txvKeterangan;
    }

    public TextView getTxvWaktu() {
        return txvWaktu;
    }
}
