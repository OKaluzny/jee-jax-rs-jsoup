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

    public static class Builder {

        private String exchange;
        private String sectorCompany;
        private String symbolCompany;
        private String exchangePrice;
        private String marketTime;

        public Builder exchange(String val) {
            exchange = val;
            return this;
        }

        public Builder sectorCompany(String val) {
            sectorCompany = val;
            return this;
        }

        public Builder symbolCompany(String val) {
            symbolCompany = val;
            return this;
        }

        public Builder exchangePrice(String val) {
            exchangePrice = val;
            return this;
        }

        public Builder marketTime(String val) {
            marketTime = val;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

    private Company(Builder builder) {

        exchange = builder.exchange;
        sectorCompany = builder.sectorCompany;
        symbolCompany = builder.symbolCompany;
        exchangePrice = builder.exchangePrice;
        marketTime = builder.marketTime;
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
                "exchange='" + exchange + '\'' +
                ", sectorCompany='" + sectorCompany + '\'' +
                ", symbolCompany='" + symbolCompany + '\'' +
                ", exchangePrice='" + exchangePrice + '\'' +
                ", marketTime='" + marketTime + '\'' +
                '}';
    }
}