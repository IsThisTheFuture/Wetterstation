package Sensoren;

public class Messung {
    private String stationsName;
    private long timestamp;
    private String property;
    private String propertyUnit;
    private long value;


    public Messung() {
        super();
        timestamp = System.currentTimeMillis() / 1000;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getStationsName() {
        return stationsName;
    }

    public void setStationsName(String stationsName) {
        this.stationsName = stationsName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getPropertyUnit() {
        return propertyUnit;
    }

    public void setPropertyUnit(String propertyUnit) {
        this.propertyUnit = propertyUnit;
    }
}
