package com.kaluzny.nasdaq.company.client;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CompanyTest {

    @Test
    public void testSetExchange() throws Exception {
        Company company = new Company();
        company.setExchange("Exchange: NASDAQ");
        assertTrue(company.getExchange() == "Exchange: NASDAQ");
    }

    @Test
    public void testSetSectorCompany() throws Exception {
        Company company = new Company();
        company.setSectorCompany("Industry: Technology");
        assertTrue(company.getSectorCompany() == "Industry: Technology");
    }

    @Test
    public void testSetSymbolCompany() throws Exception {
        Company company = new Company();
        company.setSymbolCompany("AAPL");
        assertTrue(company.getSymbolCompany() == "AAPL");
    }

    @Test
    public void testSetExchangePrice() throws Exception {
        Company company = new Company();
        company.setExchangePrice("$100");
        assertTrue(company.getExchangePrice() == "$100");
    }

    @Test
    public void testSetDataAsOf() throws Exception {
        Company company = new Company();
        company.setDataAsOf("8/23/2016");
        assertTrue(company.getDataAsOf() == "8/23/2016");
    }
}