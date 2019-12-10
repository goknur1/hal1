import java.io.Serializable;

public class Meyve extends Urun implements Serializable {

    private int meyveMiktarı;

    public Meyve() {
    }

    public Meyve(String urunAdi, double fiyat, int meyveMiktarı) {
        super(urunAdi, fiyat);
        this.meyveMiktarı = meyveMiktarı;
    }

    public int getMeyveMiktarı() {
        return meyveMiktarı;
    }

    public void setMeyveMiktarı(int meyveMiktarı) {
        this.meyveMiktarı = meyveMiktarı;
    }


    @Override
    public String getUrunTuru() {
        return "Meyve";
    }
}