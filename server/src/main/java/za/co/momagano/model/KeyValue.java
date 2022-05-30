package za.co.momagano.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValue keyValue = (KeyValue) o;
        return Objects.equals(name, keyValue.name) &&
                Objects.equals(value, keyValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
