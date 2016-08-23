package com.kaluzny;

import com.kaluzny.nasdaq.company.CompanyService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class CompanyServiceTest {

    @Test
    public void testGetExchange() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("Exchange: NASDAQ",
                parser.getExchange("AAPL"));
    }

    @Test
    public void testGetSectorCompany() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("Industry: Technology",
                parser.getSectorCompany("AAPL"));
    }

    @Ignore
    @Test
    public void testGetExchangePrice() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("$108.89",
                parser.getSectorCompany("AAPL"));
    }

    @Ignore
    @Test
    public void testdateAsOf() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("8/23/2016 12:01:04 PM",
                parser.getSectorCompany("AAPL"));
    }
}