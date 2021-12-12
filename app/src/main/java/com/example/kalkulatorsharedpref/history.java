package com.example.kalkulatorsharedpref;

public class history {
    String hasil;

    public history(String History){
        this.hasil = History;
    }

    @Override
    public String toString() {
        return hasil + '\n';
    }
}
