package com.uniyaz;

public abstract class Meyve extends Urun {

    @Override
    public void urunAlisSekli() {
        System.out.println("Adet olarak alınır.");
        setMiktarTuru(MiktarTuru.ADET);
    }
}
