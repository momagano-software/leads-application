package za.co.momagano.model;

public class KeyValue {
    private String name;
    private String value;

    public KeyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
