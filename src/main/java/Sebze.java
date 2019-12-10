import java.io.Serializable;
import java.util.Objects;

public class Sebze extends Urun implements Serializable {

    private int SebzeMiktarı;

    public Sebze() {
    }

    public Sebze(String urunAdi, double fiyat, int SebzeMiktarı) {
        super(urunAdi, fiyat);
        this.SebzeMiktarı = SebzeMiktarı;
    }

    public int getSebzeMiktarı() {
        return SebzeMiktarı;
    }

    public void setSebzeMiktarı(int sebzeMiktarı) {
        SebzeMiktarı = sebzeMiktarı;
    }


    @Override
    public String getUrunTuru() {
        return "Sebze";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SebzeMiktarı);
    }
}