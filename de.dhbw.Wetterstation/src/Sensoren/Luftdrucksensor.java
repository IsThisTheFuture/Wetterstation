package Sensoren;

public class Luftdrucksensor {
    private String DruckEinheit;

    public Luftdrucksensor(){
        super();
        DruckEinheit = "hPa";
    }

    public String getDruckEinheit() {
        return DruckEinheit;
    }

    public void setDruckEinheit(String druckEinheit) {
        DruckEinheit = druckEinheit;
    }

    public long messeLuftdruck() {
        double luftdruck = Math.random()*1000;
        return (long) luftdruck;
    }

}
