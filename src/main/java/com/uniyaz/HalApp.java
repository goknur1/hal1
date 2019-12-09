package com.uniyaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static com.uniyaz.App.stokList;

public class HalApp {
    static ArrayList<Stok> urun = new ArrayList<Stok>();
    public static void main(String[] args) {
        // write your code here

        boolean cikis=false;
        Scanner tara =new Scanner(System.in);
        byte secim=-1;
        while (!cikis) {
            System.out.println("----- REHBER ------");
            System.out.println("0 - Yeni Kayıt Ekle \n1 - Kişi Güncelle \n2 - Kişi Ara \n3 - Kişi Sil \n4 - Listele\n5 - Çıkış");
            System.out.println(" \n Bir Seçenek Seçiniz : ");
            secim=tara.nextByte();

            switch (secim){
                case 0:
                    secme();
                    break;
                case 1:
                    stokListeleme();
                    break;
                case 2:

                    break;
                case 3:

                case 4:

                    break;
                default:
                    break;

            }

        }

    }


    private static void secme() {
        Scanner scanner = new Scanner(System.in);
        Personel personel = new Personel();

        System.out.println( "Adınızı giriniz: " );

        String personelAdi = scanner.nextLine();
        personel.setPersonelAdi(personelAdi);
        System.out.println("Şeçim Yapınız:");
        System.out.println("1. Meyve kaydı");
        System.out.println("2. Sebze Kaydı");
        int secim = scanner.nextInt();

        if(secim == 1){
            System.out.println("1. Elma kaydı");
            System.out.println("2. Armut kaydı");
            int secim2 = scanner.nextInt();
            System.out.println("Alınan miktarı giriniz: ");
            int alinanMiktar = scanner.nextInt();

            if (secim2 == 1){
                Urun urun = new Elma();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
            }else if (secim2 == 2){
                Urun urun = new Cilek();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
            }

        }else if (secim == 2){
            System.out.println("1. Brokoli kaydı");
            System.out.println("2. Pırasa kaydı");
            int secim2 = scanner.nextInt();
            System.out.println("Alınan miktarı giriniz: ");
            int alinanMiktar = scanner.nextInt();

            if (secim2 == 1){
                Urun urun = new Sogan();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
            }else if (secim2 == 2){
                Urun urun = new Pirasa();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
            }
        }

        scanner.nextLine();
        System.out.println( );
    }
    private static void stokListeleme() {
        Iterator<Stok> kisiIterator=stokList.listIterator();
        int sayac=-1;
        boolean firstTime=true;
        if(stokList.size()>0) {
            while (kisiIterator.hasNext()) {
                sayac++;
                Stok stok = kisiIterator.next();

                if (firstTime) {
                    // Sadece Ekranın En Üst kısmına başlık olarak yazalım
                    System.out.println();
                    System.out.println(" \t\t\t\t TÜM KAYITLAR  \t\t\t\t");
                    System.out.println("\t\t ID \t\t ADI \t\t SOYAD \t\t\t NUMARA \t\t  ");
                    System.out.println("---------------------------------------------------------------");
                    System.out.println();
                    firstTime = false;
                }
                System.out.println("\t" +sayac + "\t\t" + stok.getUrunAlanEleman() +"\t\t" + stok.getUrunMiktari() + "\t\t\t" );


            }
            System.out.println();
            System.out.println("Toplamda "+ stokList.size()+" Kayıt Listelendi !");

        }
        else
        {
            System.out.println("Listelenecek Herhangi bir Kayıt Bulunamadı");
        }

    }


}





