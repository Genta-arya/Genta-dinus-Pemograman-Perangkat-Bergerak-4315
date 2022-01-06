package com.example.styleku;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class barangadapter extends BaseAdapter {
    Activity activity;
    List<barang_list> toko;
    private LayoutInflater inflater;

    public barangadapter(Activity activity, List<barang_list> toko){
        this.activity = activity;
        this.toko = toko;
    }
    @Override
    public int getCount() {
        return (toko.size());
    }

    @Override
    public Object getItem(int i) {
        return toko.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(R.layout.barang,null);
        TextView id_barang = (TextView) convertView.findViewById(R.id.id_barangs);
        TextView nama_seller = (TextView) convertView.findViewById(R.id.username_brg_seller);
        TextView nama_toko = (TextView) convertView.findViewById(R.id.nama_tokos);
        TextView nama_barang= (TextView) convertView.findViewById(R.id.nama_brgs);
        TextView harga = (TextView) convertView.findViewById(R.id.harga_brgs);
        TextView qty= (TextView) convertView.findViewById(R.id.qtys);


        barang_list barang_lists = toko.get(i);
        id_barang.setText(barang_lists.getId_barang());
        nama_seller.setText(barang_lists.getNama_Sellers());
        nama_toko.setText(barang_lists.getNama_tokos());
        nama_barang.setText(barang_lists.getNama_barangs());
        harga.setText(barang_lists.getHargas());
        qty.setText(barang_lists.getQtyss());


        return convertView;

    }
}
