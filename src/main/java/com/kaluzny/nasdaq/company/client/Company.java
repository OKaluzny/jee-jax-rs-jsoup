package com.kaluzny.nasdaq.company.client;

/*
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllCompanies", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "findBookExchange", query = "SELECT c FROM Company c WHERE c.exchange ='AAPL'")
})*/
public class Company {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String exchange;

    //@Column(name = "sector_company")
    private String sectorCompany;

    //@Column(name = "symbol_company")
    //@Size(max = 10)
    private String symbolCompany;

    // @Column(name = "exchange_price")
    // @NotNull
    private String exchangePrice;

    //@Column(name = "market_time")
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