package Sensoren;

public class Luftfeuchtigkeitssensor {
    private String feuchtigkeitEinheit;

    public Luftfeuchtigkeitssensor(){
        super();
        feuchtigkeitEinheit = "%";
    }

    public String getFeuchtigkeitEinheit() {
        return feuchtigkeitEinheit;
    }

    public void setFeuchtigkeitEinheit(String feuchtigkeitEinheit) {
        this.feuchtigkeitEinheit = feuchtigkeitEinheit;
    }

    public long messeLuftfeuchtigkeit() {
        double luftfeuchtigkeit = Math.random()*100;
        return (long) luftfeuchtigkeit;
    }
}
