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
}