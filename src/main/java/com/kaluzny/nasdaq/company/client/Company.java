package com.kaluzny.nasdaq.company.client;

public class Company {

    private String exchange;
    private String sectorCompany;
    private String symbolCompany;
    private String exchangePrice;
    private String dataAsOf;

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setSectorCompany(String sectorCompany) {
        this.sectorCompany = sectorCompany;
    }

    public void setSymbolCompany(String symbolCompany) {
        this.symbolCompany = symbolCompany;
    }

    public void setExchangePrice(String exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public void setDataAsOf(String dataAsOf) {
        this.dataAsOf = dataAsOf;
    }

    public String getExchange() {
        return exchange;
    }

    public String getSectorCompany() {
        return sectorCompany;
    }

    public String getSymbolCompany() {
        return symbolCompany;
    }

    public String getExchangePrice() {
        return exchangePrice;
    }

    public String getDataAsOf() {
        return dataAsOf;
    }

    @Override
    public String toString() {
        return "Company{" +
                "exchange='" + exchange + '\'' +
                ", sectorCompany='" + sectorCompany + '\'' +
                ", symbolCompany='" + symbolCompany + '\'' +
                ", exchangePrice='" + exchangePrice + '\'' +
                ", dataAsOf='" + dataAsOf + '\'' +
                '}';
    }
}