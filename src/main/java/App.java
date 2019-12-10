import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class App {

    static List<Satis> satisList = new ArrayList<>();
    static ArrayList<Stok> stokList = new ArrayList();

    //Meyve cilek = new Cilek(1,"ÇİLEK",MiktarTuru.KILO);
    //cilek.setUcret(3);
    //Meyvelist.add(cilek);

    //Meyve erik = new Erik(2,"ERİK",MiktarTuru.KILO);
    //erik.setUcret(4);
    //Meyvelist.add(erik);

     //Sebze karnibahar = new Karnibahar(3,"KARNIBAHAR",MiktarTuru.KILO);
   // karnibahar.setUcret(5);
   // sebzeList.add(karnibahar);

    //Sebze pirasa = new Pirasa(1,"PIRASA",MiktarTuru.KILO);
   // pirasa.setUcret(2);
    //sebzeList.add(pirasa);

   static boolean cikis=false;

    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------HAL STOK PROGRAMINA HOŞGELDİNİZ----------------");
        System.out.println("1. Ürün Ekleyiniz...\n" +
                "2. Satış Yapınız...\n" +
                "3. Stokları Listele...\n" +
                "4. Çıkış...");
        System.out.println("-------------------------------------------------------------");
        while (!cikis) {
            System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz: ");
            int secimMenu=scanner.nextInt();
            switch (secimMenu) {
                case 1:
                    urunEkle(stokList, scanner);
                    break;
                case 2:
                    urunSat(scanner);
                    break;
                case 3:
                    stokTakip(stokList, scanner);
                    break;
                case 4:
                    cikis=true;
                    break;
            }
        }
    }

    public static void listele() {
        System.out.println();
        System.out.println("\t Urun No \t\t Urun Adı\t\t");
        System.out.println("--------------------------------------");
        for (Stok stok: stokList) {
            System.out.println("\t" +stok.getUrun().getId() + "\t\t" + stok.getUrun().getUrunAdi()+"\t\t"+stok.getAdet()+"kg");
        }

        stoklariDosyayaObjeOlarakYaz(stokList);

        stoklariDosyadanOku();
        for (Stok stok : stokList) {
            System.out.println(stok.getUrun());
        }


    }

    private static void urunSat(Scanner scanner) {
        System.out.print("Müşteri Adı: ");
        scanner.nextLine();
        String gelenMusteri=scanner.nextLine();
        listele();
        System.out.print("\nİstediğiniz Ürünün ID'sini Giriniz: ");
        int istedigiUrun = scanner.nextInt();

        System.out.print("Ürün Miktarını Giriniz: ");
        int istedigiAdet=scanner.nextInt();

        Musteri musteri=new Musteri(gelenMusteri);
        Satis satis= new Satis();
        for (Stok stok:stokList) {

            if(stok.getUrun().getId()==istedigiUrun)
            {
                if (stok.getAdet()>=istedigiAdet)
                {
                    stok.setAdet(stok.getAdet()-istedigiAdet);
                    satis = new Satis(musteri, stok.getUrun(),istedigiAdet, LocalDateTime.now());
                }else{
                    System.out.println("Stokda Yeterli Ürün Adeti Yok. Stok Adeti : " +stok.getAdet());
                }

            }
        }
        listele();

    }

    private static void urunEkle(ArrayList<Stok> stokList, Scanner scanner) {
        System.out.print("Personel Adınızı Giriniz: ");
        scanner.nextLine();
        String gelenPersonel = scanner.nextLine();
        Personel personel = new Personel(gelenPersonel);
        System.out.println("Sebze için 1'i Seçiniz \n"+
                "Meyve için 2'yi Seçiniz");
        int secimUrun = scanner.nextInt();
        if (secimUrun == 1) {
            System.out.print("Ürünün Adı: ");
            scanner.nextLine();
            String gelenUrunAd = scanner.nextLine();

            System.out.print("Ürünün Fiyatı: ");
            double gelenFiyat = scanner.nextInt();

            System.out.print("Ürünün Adet:");
            int gelenAdet = scanner.nextInt();

            Sebze sebze = new Sebze(gelenUrunAd, gelenFiyat, gelenAdet);
            Stok stok=new Stok(personel,sebze,gelenAdet);
            stokList.add(stok);
        }
        else if (secimUrun == 2) {
            System.out.print("Ürünün Adı: ");
            String gelenUrunAd = scanner.next();

            System.out.print("Ürünün Fiyatı: ");
            double gelenFiyat = scanner.nextInt();

            System.out.print("Ürünün Adeti:");
            int gelenUrunAdet = scanner.nextInt();

            Meyve meyve = new Meyve(gelenUrunAd, gelenFiyat, gelenUrunAdet);
            Stok stok=new Stok(personel,meyve,gelenUrunAdet);
            stokList.add(stok);
        }

    }

    private static void stokTakip(ArrayList<Stok> stokList, Scanner scanner) {
        System.out.println("Listelemek istediğiniz ürünü seçin");
        System.out.println("Sebze için 1'e ********Meyve için 2'ye\"");
        int toplamAdet=0;
        int girilenDeger = scanner.nextInt();
        if(girilenDeger==1){
            for (Stok stok : stokList) {
                if(stok.getUrun().getUrunTuru().equals("Sebze")){
                    toplamAdet += stok.getAdet();

                }
            }
            System.out.println("Sebze'nin toplam kilosu : "+toplamAdet);
        }
        else if(girilenDeger==2){
            for (Stok stok : stokList) {
                if(stok.getUrun().getUrunTuru().equals("Meyve")){
                    toplamAdet += stok.getAdet();
                }
            }
            System.out.println("Meyve'nin toplam kilosu : "+toplamAdet);
        }
    }

//
//        System.out.println("Toplamı istenen ürünü giriniz:");
//        System.out.println("1. Cilek\n 2.Erik\n 3. Karnibahar\n 4. Pirasa\n");
//        int secim = scanner.nextInt();
//        String secilenUrunAdi;
//        if (secim == 1){
//            secilenUrunAdi =
//        }


    private static void stoklariDosyayaObjeOlarakYaz(List<Stok> stokList) {

        try (FileOutputStream fileOut = new FileOutputStream(".//stokObje.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            objectOut.writeObject(stokList);
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static List<Stok> stoklariDosyadanOku() {
        List<Stok> stokList = null;
        try (FileInputStream fileOut = new FileInputStream(".//stokObje.txt");
             ObjectInputStream objectOut = new ObjectInputStream(fileOut);) {
            stokList = (List<Stok>) objectOut.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stokList;
    }
}