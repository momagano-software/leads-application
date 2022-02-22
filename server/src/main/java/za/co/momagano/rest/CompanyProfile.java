package za.co.momagano.rest;

import java.io.Serializable;

public class CompanyProfile implements Serializable {
    private String tradingName;

    public void setTradingName(String tradingName) {

        this.tradingName = tradingName;
    }

    public String getTradingName() {
        return tradingName;
    }
}
