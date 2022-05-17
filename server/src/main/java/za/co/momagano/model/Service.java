package za.co.momagano.model;

import java.io.Serializable;
import java.util.List;

public class Service implements Serializable {
    private String serviceName;
    private Integer servicePrice;
    private Integer serviceType;
    private String servicePricePerUnit;
    private Boolean remote;
    private List<FAQ> myFAQ;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }
    public Service(){

    }

    public String getServiceName() {
        return serviceName;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public String getServicePricePerUnit() {
        return servicePricePerUnit;
    }

    public Boolean getRemote() {
        return remote;
    }

    public List<FAQ> getMyFAQ() {
        return myFAQ;
    }
}
