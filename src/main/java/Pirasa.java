import java.io.Serializable;

public class Pirasa extends Sebze implements Serializable
{
    public Pirasa(int i, String pirasa, MiktarTuru kilo) {
    }

    @Override
    public String getUrunAdi() {
        return "Pırasa";
    }
}
