package za.co.momagano.model;

import java.util.List;
import java.util.Objects;

public class SubCategory extends KeyValue {

    List<KeyValue> serviceList;

    public SubCategory(String name, String value, List<KeyValue> serviceList) {
        super(name, value);
        this.serviceList = serviceList;
    }

    public List<KeyValue> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<KeyValue> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return Objects.equals(serviceList, that.serviceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceList);
    }
}
