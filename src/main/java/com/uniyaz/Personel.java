package com.uniyaz;

import java.util.List;
import java.util.Objects;

public class Personel implements  UrunAlabilir{
    private int id;
    private String personelAdi;
    private int alinanUrunMiktari;

    @Override
    public void urunAl(Urun urun, double miktar, Stok stok) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel personel = (Personel) o;
        return id == personel.id &&
                alinanUrunMiktari == personel.alinanUrunMiktari &&
                Objects.equals(personelAdi, personel.personelAdi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personelAdi, alinanUrunMiktari);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public int getAlinanUrunMiktari() {
        return alinanUrunMiktari;
    }

    public void setAlinanUrunMiktari(int alinanUrunMiktari) {
        this.alinanUrunMiktari = alinanUrunMiktari;
    }
}
