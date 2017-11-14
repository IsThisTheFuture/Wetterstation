import Sensoren.*;

public class Wetterstation {
    private Messung messung;
    private StringBuilder builder;
    private Temperatursensor temperatursensor;
    private Luftfeuchtigkeitssensor luftfeuchtigkeitssensor;
    private Luftdrucksensor luftdrucksensor;

    public Wetterstation() {
        super();
        temperatursensor = new Temperatursensor();
        luftfeuchtigkeitssensor = new Luftfeuchtigkeitssensor();
        luftdrucksensor = new Luftdrucksensor();
    }

    public String getMesswerte(){
        messung = new Messung();
        messung.setTemperatur(temperatursensor.messeTemperatur());
        messung.setLuftfeuchtigkeit(luftfeuchtigkeitssensor.messeLuftfeuchtigkeit());
        messung.setLuftdruck(luftdrucksensor.messeLuftdruck());

        return buildResultString(messung);
    }

    private String buildResultString(Messung messung){
        builder = new StringBuilder();

        builder.append("Temperatursensor: ");
        builder.append(messung.getTemperatur());
        builder.append("° ");
        builder.append(temperatursensor.getTempEinheit());

        builder.append(", Luftfeuchtigkeitssensor: ");
        builder.append(messung.getLuftfeuchtigkeit());
        builder.append(luftfeuchtigkeitssensor.getFeuchtigkeitEinheit());

        builder.append(", Luftdrucksensor: ");
        builder.append(messung.getLuftdruck());
        builder.append(" ");
        builder.append(luftdrucksensor.getDruckEinheit());

        return builder.toString();
    }
}