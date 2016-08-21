package com.kaluzny;

import com.kaluzny.nasdaq.company.CompanyService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CompanyServiceTest {

    @Test
    public void parseTest() throws IOException {
        CompanyService parser = new CompanyService();

        Assert.assertEquals("Nasdaq, Inc. Common Stock Real Time Stock Quotes",
                parser.getNameCompany("International Business Machines Corporation " +
                        "Common Stock Real Time Stock Quotes"));
    }

    @Test
    public void sectorCompanyTest() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("Industry: Finance",
                parser.getSectorCompany("International Business Machines Corporation " +
                        "Common Stock Real Time Stock Quotes"));
    }

    @Test
    public void getDataAsOfTest() throws IOException {
        CompanyService parser = new CompanyService();
        Assert.assertEquals("$70.44",
                parser.getStockQuotes("International Business Machines Corporation " +
                        "Common Stock Real Time Stock Quotes"));

    }
}