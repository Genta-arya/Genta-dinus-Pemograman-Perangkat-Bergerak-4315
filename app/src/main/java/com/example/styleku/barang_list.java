package com.example.styleku;

public class barang_list {
    private  String id_barang,nama_tokos,nama_Sellers,nama_barangs,qtyss,hargas;

    public barang_list() {
    }

    public barang_list(String id_barang,String nama_Sellers, String nama_tokos,String qtyss,String hargas){
        this.id_barang = id_barang;
        this.nama_tokos = nama_tokos;
        this.nama_Sellers = nama_Sellers;
        this.hargas = hargas;
        this.qtyss = qtyss;



    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_tokos() {
        return nama_tokos;
    }

    public void setNama_tokos(String nama_tokos) {
        this.nama_tokos = nama_tokos;
    }

    public String getNama_Sellers() {
        return nama_Sellers;
    }

    public void setNama_Sellers(String nama_Sellers) {
        this.nama_Sellers = nama_Sellers;
    }

    public String getNama_barangs() {
        return nama_barangs;
    }

    public void setNama_barangs(String nama_barangs) {
        this.nama_barangs = nama_barangs;
    }

    public String getQtyss() {
        return qtyss;
    }

    public void setQtyss(String qtyss) {
        this.qtyss = qtyss;
    }

    public String getHargas() {
        return hargas;
    }

    public void setHargas(String hargas) {
        this.hargas = hargas;
    }

}
