package com.kaluzny.nasdaq.company.client;

import com.kaluzny.nasdaq.company.Company;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompanyTest {

    private static final String EXCHANGE = "Exchange: NASDAQ";
    private static final String SECTOR_COMPANY = "Industry: Technology";
    private static final String COMPANY = "AAPL";
    private static final String EXCHANGE_PRICE = "$100";
    private static final String MARKET_TIME = "8/23/2016";

    @Test
    public void testSetExchange() throws Exception {
        Company company = new Company();
        company.setExchange(EXCHANGE);
        assertTrue(company.getExchange().equalsIgnoreCase(EXCHANGE));
        assertFalse(SECTOR_COMPANY, false);
    }

    @Test
    public void testSetSectorCompany() throws Exception {
        Company company = new Company();
        company.setSectorCompany(SECTOR_COMPANY);
        assertTrue(company.getSectorCompany().equalsIgnoreCase(SECTOR_COMPANY));
        assertFalse(EXCHANGE, false);
    }

    @Test
    public void testSetSymbolCompany() throws Exception {
        Company company = new Company();
        company.setSymbolCompany(COMPANY);
        assertTrue(company.getSymbolCompany().equalsIgnoreCase(COMPANY));
        assertFalse(SECTOR_COMPANY, false);
    }

    @Test
    public void testSetExchangePrice() throws Exception {
        Company company = new Company();
        company.setExchangePrice(EXCHANGE_PRICE);
        assertTrue(company.getExchangePrice().equalsIgnoreCase(EXCHANGE_PRICE));
        assertFalse(SECTOR_COMPANY, false);
    }

    @Test
    public void testSetDataAsOf() throws Exception {
        Company company = new Company();
        company.setMarketTime(MARKET_TIME);
        assertTrue(company.getMarketTime().equalsIgnoreCase(MARKET_TIME));
        assertFalse(SECTOR_COMPANY, false);
    }
}
