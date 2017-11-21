import Sensoren.*;

public class Wetterstation {
    private String stationsName;
    private Messung messung;
    private StringBuilder builder;
    private Temperatursensor temperatursensor;
    private Luftfeuchtigkeitssensor luftfeuchtigkeitssensor;
    private Luftdrucksensor luftdrucksensor;

    public Wetterstation(String stationsName) {
        super();
        this.stationsName = stationsName;
        temperatursensor = new Temperatursensor();
        luftfeuchtigkeitssensor = new Luftfeuchtigkeitssensor();
        luftdrucksensor = new Luftdrucksensor();
    }

    public String messeTemperatur(){
        messung = new Messung();
        messung.setStationsName(this.stationsName);
        messung.setProperty("Temperatur");
        messung.setPropertyUnit(temperatursensor.getTempEinheit());
        messung.setValue(temperatursensor.messeTemperatur());

        return buildResultString(messung);
    }

    public String messeLuftfeuchtigkeit(){
        messung.setStationsName(this.stationsName);
        messung.setProperty("Luftfeuchtigkeit");
        messung.setPropertyUnit(luftfeuchtigkeitssensor.getFeuchtigkeitEinheit());
        messung.setValue(luftfeuchtigkeitssensor.messeLuftfeuchtigkeit());
        return buildResultString(messung);
    }

    public String messeLuftdruck(){
        messung.setStationsName(this.stationsName);
        messung.setProperty("Luftdruck");
        messung.setPropertyUnit(luftdrucksensor.getDruckEinheit());
        messung.setValue(luftdrucksensor.messeLuftdruck());
        return buildResultString(messung);
    }

    private String buildResultString(Messung messung){
        builder = new StringBuilder();

        builder.append(messung.getStationsName());
        builder.append(" ");
        builder.append(messung.getTimestamp());
        builder.append(" ");
        builder.append(messung.getProperty());
        builder.append(" ");
        builder.append(messung.getPropertyUnit());
        builder.append(" ");
        builder.append(messung.getValue());

        return builder.toString();
    }
}