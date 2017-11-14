package Sensoren;

public class Messung {
    private long temperatur;
    private long luftfeuchtigkeit;
    private long luftdruck;

    public Messung() {
        super();
    }

    public long getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(long temperatur) {
        this.temperatur = temperatur;
    }

    public long getLuftfeuchtigkeit() {
        return luftfeuchtigkeit;
    }

    public void setLuftfeuchtigkeit(long luftfeuchtigkeit) {
        this.luftfeuchtigkeit = luftfeuchtigkeit;
    }

    public long getLuftdruck() {
        return luftdruck;
    }

    public void setLuftdruck(long luftdruck) {
        this.luftdruck = luftdruck;
    }
}
