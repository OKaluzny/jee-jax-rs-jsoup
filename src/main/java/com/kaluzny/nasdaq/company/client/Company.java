package com.kaluzny.nasdaq.company.client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Company {

    private String exchange;
    private String sectorCompany;
    @Size(max = 10)
    private String symbolCompany;
    @NotNull
    private String exchangePrice;
    private String marketTime;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSectorCompany() {
        return sectorCompany;
    }

    public void setSectorCompany(String sectorCompany) {
        this.sectorCompany = sectorCompany;
    }

    public String getSymbolCompany() {
        return symbolCompany;
    }

    public void setSymbolCompany(String symbolCompany) {
        this.symbolCompany = symbolCompany;
    }

    public String getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(String exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public String getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(String marketTime) {
        this.marketTime = marketTime;
    }

    @Override
    public String toString() {
        return "Company{" +
                "exchange='" + exchange + '\'' +
                ", sectorCompany='" + sectorCompany + '\'' +
                ", symbolCompany='" + symbolCompany + '\'' +
                ", exchangePrice='" + exchangePrice + '\'' +
                ", marketTime='" + marketTime + '\'' +
                '}';
    }
}