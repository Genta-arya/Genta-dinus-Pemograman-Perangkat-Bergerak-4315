package com.example.styleku;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class tokoAdapter extends BaseAdapter {
    Activity activity;
    List<data_list> toko;
    private LayoutInflater inflater;

    public tokoAdapter(Activity activity, List<data_list> toko){
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
        if (convertView == null) convertView = inflater.inflate(R.layout.list_view,null);
        TextView id_seller = (TextView) convertView.findViewById(R.id.id_sellers);
        TextView nama_toko = (TextView) convertView.findViewById(R.id.nama_toko);


        data_list data_lists = toko.get(i);
        id_seller.setText(data_lists.getId_toko());
        nama_toko.setText(data_lists.getNama_toko());


        return convertView;

    }
}
