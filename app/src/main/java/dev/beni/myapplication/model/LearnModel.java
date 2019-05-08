package dev.beni.myapplication.model;

import android.util.Log;

public class LearnModel {
    private String judul, deskripsi;

    public LearnModel(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {return judul;}
    public void setJudul(String judul) {this.judul = judul;}

    public String getDeskripsi() {return deskripsi;}
    public void setDeskripsi(String deskripsi) {this.deskripsi = deskripsi;}
}