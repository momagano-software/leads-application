package za.co.momagano.model;

import java.util.List;

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
}
