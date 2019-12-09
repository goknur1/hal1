package com.uniyaz;

public abstract class Sebze extends Urun {

    @Override
    public void urunAlisSekli() {
        System.out.println("Kilo olarak alınır.");
        setMiktarTuru(MiktarTuru.KİLO);
    }
//
//    @Override
//    public void setUrunFiyati(double urunFiyati) {
//
//    }
}
