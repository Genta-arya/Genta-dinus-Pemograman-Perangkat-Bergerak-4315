package com.example.styleku;

public class data_list {
    private  String id_toko,nama_toko;

    public data_list() {
    }

    public data_list(String id_toko, String nama_toko){
        this.id_toko = id_toko;
        this.nama_toko = nama_toko;


    }

    public String getId_toko() {
        return id_toko;
    }

    public void setId_toko(String id_toko) {
        this.id_toko = id_toko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }


}
