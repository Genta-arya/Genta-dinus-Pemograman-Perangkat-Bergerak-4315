package com.example.menumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterMenu extends  RecyclerView.Adapter<AdapterMenu.ViewHolder>{
    private ArrayList<String> gambarMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private ArrayList<String> deskripsiMakanan = new ArrayList<>();
    private ArrayList<String> hargamakanan = new ArrayList<>();
    private Context context;

    public AdapterMenu(ArrayList<String> gambarMakanan, ArrayList<String> namaMakanan,ArrayList<String>deskripsiMakanan,ArrayList<String>hargamakanan, Context context) {
        this.gambarMakanan = gambarMakanan;
        this.namaMakanan = namaMakanan;
        this.deskripsiMakanan = deskripsiMakanan;
        this.hargamakanan = hargamakanan;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deskripsi,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
//
    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
            Glide.with(context).asBitmap().load(gambarMakanan.get(position)).into(holder.gambar);
            holder.nama.setText(namaMakanan.get(position));
            holder.layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DeskripsiActivity2.class);
                    intent.putExtra("foto_makanan",gambarMakanan.get(position));
                    intent.putExtra("nama_makanan",namaMakanan.get(position));
                    intent.putExtra("deskripsi_makanan",deskripsiMakanan.get(position));
                    intent.putExtra("harga_makanan",hargamakanan.get(position));
                    context.startActivity(intent);


                }
            });

    }

    @Override
    public int getItemCount() {
        return namaMakanan.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama;
        ConstraintLayout constraintLayout;
        ConstraintLayout layout2;

        public ViewHolder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById((R.id.imageMakanan));
            nama = itemView.findViewById((R.id.textAdapternama));
            constraintLayout = itemView.findViewById((R.id.constraintLayout));
            layout2 = itemView.findViewById((R.id.txtdeskripsi));
        }
    }
}
