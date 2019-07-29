package com.ardananjung.catatanharian.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ardananjung.catatanharian.R;
import com.ardananjung.catatanharian.data.Aktifitas;

import java.util.ArrayList;
import java.util.List;

public class AktifitasItemViewHolder extends RecyclerView.Adapter<AktifitasItemViewHolder.MyViewHolder>{
    List<Aktifitas> aktifitasList= new ArrayList<>();

    public AktifitasItemViewHolder(List<Aktifitas> aktifitasList) {
        this.aktifitasList = aktifitasList;
    }


    // Untuk kebutuhan onClick pada item recycler view
    private onAktifitasClickListener listener;

    public interface onAktifitasClickListener{
        public void onClick(View view, int position);
    }

    public void setListener(onAktifitasClickListener listener){
        this.listener = listener;
    }
    // Ending Code - Untuk kebutuhan onClick pada item recycler view

    @NonNull
    @Override
    public AktifitasItemViewHolder.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aktifitas_item_view, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AktifitasItemViewHolder.MyViewHolder holder, int position) {
        Aktifitas aktifitas = aktifitasList.get(position);

        holder.nama.setText(aktifitas.getNamaKegiatan());
        holder.keterangan.setText(aktifitas.getKeterangan());
        holder.waktu.setText(aktifitas.getWaktu());

        //tidak di tampilkan dalam tampilan
        holder.id.setText(String.valueOf(aktifitas.getId()));
    }

    @Override
    public int getItemCount() {
        return aktifitasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama,keterangan,waktu,id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.idKegiatan);
            nama = itemView.findViewById(R.id.namaKegiatan);
            keterangan = itemView.findViewById(R.id.keteranganKegiatan);
            waktu=itemView.findViewById(R.id.waktuKegiatan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }
}
