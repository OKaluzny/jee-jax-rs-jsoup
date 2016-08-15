package com.kaluzny.nasdaq.company.client;

public class Company {

    private String exchange;
    private String nameCompany;
    private String sectorCompany;
    private String symbolCompany;
    private String stockQuotes;
    private String dataAsOf;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
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

    public String getStockQuotes() {
        return stockQuotes;
    }

    public void setStockQuotes(String stockQuotes) {
        this.stockQuotes = stockQuotes;
    }

    public String getDataAsOf() {
        return dataAsOf;
    }

    public void setDataAsOf(String dataAsOf) {
        this.dataAsOf = dataAsOf;
    }
}