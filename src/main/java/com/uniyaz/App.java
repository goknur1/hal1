package com.uniyaz;

import java.util.*;

public class App {

    static List<Stok> stokList = new ArrayList<>();
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        String cevap;
        boolean yeniKayit = true;
        do{
            kayitOlustur();
            stoklariListele(stokList);

            System.out.println("Yeni kayıt için 1 tuşuna basınız.");
            cevap = scanner.nextLine();
            if (cevap.equals("1")){
                yeniKayit = true;
            }else {
                yeniKayit = false;
            }

        }while (yeniKayit);


    }

    public static void kayitOlustur(){
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
            System.out.println("2. Çilek kaydı");
            int secim2 = scanner.nextInt();
            System.out.println("Alınan miktarı giriniz: ");
            int alinanMiktar = scanner.nextInt();



            if (secim2 == 1){
                Urun urun = new Elma();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
                System.out.println(stok.getUrunAlanEleman() +"\t\t" + stok.getUrunMiktari() + "\t\t\t");
            }else if (secim2 == 2){
                Urun urun = new Cilek();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
                System.out.println(stok.getUrunAlanEleman() +"\t\t" + stok.getUrunMiktari() + "\t\t\t");
            }

        }else if (secim == 2){
            System.out.println("1. Soğan kaydı");
            System.out.println("2. Pırasa kaydı");
            int secim2 = scanner.nextInt();
            System.out.println("Alınan miktarı giriniz: ");
            int alinanMiktar = scanner.nextInt();

            if (secim2 == 1){
                Urun urun = new Sogan();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
                System.out.println("\t\t" +  stok.getUrunAlanEleman() +"\t\t" + stok.getUrunMiktari() +stok.getFiyat()+ "\t\t\t");
            }else if (secim2 == 2){
                Urun urun = new Pirasa();
                Stok stok = new Stok(urun , personel, alinanMiktar);
                personel.urunAl(urun, alinanMiktar, stok);
                System.out.println(stok.getUrunAlanEleman() +"\t\t" + stok.getUrunMiktari() + "\t\t\t");
            }
        }

        scanner.nextLine();
        System.out.println( );
    }

    public static void stoklariListele(List<Stok> stokList ){
        stoklariListele(stokList);
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

