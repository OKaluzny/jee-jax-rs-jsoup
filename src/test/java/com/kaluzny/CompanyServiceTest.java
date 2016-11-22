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
        Assert.assertEquals("Exchange:NASDAQ", parser.getExchange("AAPL"));
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
        Assert.assertEquals("Industry: Technology",
                parser.getSectorCompany("AAPL"));
    }
}
