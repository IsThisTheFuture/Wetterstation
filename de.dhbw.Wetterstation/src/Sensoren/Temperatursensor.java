package Sensoren;

public class Temperatursensor {

    private String tempEinheit;

    public Temperatursensor() {
        super();
        tempEinheit = "Celsius";
    }

    public String getTempEinheit() {
        return tempEinheit;
    }

    public void setTempEinheit(String tempEinheit) {
        this.tempEinheit = tempEinheit;
    }

    public long messeTemperatur() {
        double temperatur = (Math.random()*75) - 25;
        return (long) temperatur;
    }

}
