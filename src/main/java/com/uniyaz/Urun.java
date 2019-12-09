package com.uniyaz;

import java.util.Objects;

public abstract class Urun {
    private int id;
    private double urunFiyati;
    private MiktarTuru miktarTuru;  //// enum

    public abstract void urunAlisSekli();

    public abstract String getUrunAdi();

    @Override
    public boolean equals(Object o) {
        //// Gelen nesne bulunan sınıfın nesnesine cast edilerek
        //// nesnenin id'si ile sınıfın id değeri karşılaştırılır.
        Urun urun = (Urun) o;
       return this.id == urun.getId();
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(double urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MiktarTuru getMiktarTuru() {
        return miktarTuru;
    }

    public void setMiktarTuru(MiktarTuru miktarTuru) {
        this.miktarTuru = miktarTuru;
    }
}


