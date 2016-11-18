package com.kaluzny.nasdaq.company;

public class Company {

    private Long id;
    private String exchange;
    private String sectorCompany;
    private String symbolCompany;
    private String exchangePrice;
    private String marketTime;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", exchange='" + exchange + '\'' +
                ", sectorCompany='" + sectorCompany + '\'' +
                ", symbolCompany='" + symbolCompany + '\'' +
                ", exchangePrice='" + exchangePrice + '\'' +
                ", marketTime='" + marketTime + '\'' +
                '}';
    }
}