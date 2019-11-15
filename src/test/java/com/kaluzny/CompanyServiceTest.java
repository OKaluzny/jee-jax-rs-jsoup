package com.kaluzny;

import com.kaluzny.nasdaq.company.Company;
import com.kaluzny.nasdaq.company.CompanyService;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CompanyServiceTest {

    private static final String COMPANY = "AAPL";

    @Mock
    private Document document;

    @Mock
    private Company company;

    @Test
    public void testGetDocument() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(document).when(spyParser).getDocument(any());
        spyParser.getDocument(COMPANY);
        verify(spyParser, times(1)).getDocument(COMPANY);
        assertEquals(document, spyParser.getDocument(COMPANY));
        assertNotEquals(COMPANY, spyParser.getDocument(COMPANY));
    }

    @Test
    public void testGetExchange() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(COMPANY).when(spyParser).getExchange(any());
        spyParser.getExchange(COMPANY);
        verify(spyParser, times(1)).getExchange(COMPANY);
        assertEquals(COMPANY, spyParser.getExchange(COMPANY));
        assertNotEquals("Alfa", spyParser.getExchange(COMPANY));
    }

    @Test
    public void testGetSectorCompany() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(COMPANY).when(spyParser).getSectorCompany(any());
        spyParser.getSectorCompany(COMPANY);
        verify(spyParser, times(1)).getSectorCompany(COMPANY);
        assertEquals(COMPANY, spyParser.getSectorCompany(COMPANY));
        assertNotEquals("Alfa", spyParser.getSectorCompany(COMPANY));
    }

    @Test
    public void testGetExchangePrice() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(COMPANY).when(spyParser).getExchangePrice(any());
        spyParser.getExchangePrice(COMPANY);
        verify(spyParser, times(1)).getExchangePrice(COMPANY);
        assertEquals(COMPANY, spyParser.getExchangePrice(COMPANY));
        assertNotEquals("Alfa", spyParser.getExchangePrice(COMPANY));
    }

    @Test
    public void testGetMarketTime() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(COMPANY).when(spyParser).getMarketTime(any());
        spyParser.getMarketTime(COMPANY);
        verify(spyParser, times(1)).getMarketTime(COMPANY);
        assertEquals(COMPANY, spyParser.getMarketTime(COMPANY));
        assertNotEquals("Alfa", spyParser.getMarketTime(COMPANY));
        doThrow(new RuntimeException()).when(spyParser).getMarketTime(any());
    }

    @Test
    public void testBuildCompany() throws IOException {
        CompanyService spyParser = spy(CompanyService.class);
        doReturn(company).when(spyParser).buildCompany(anyString());
        spyParser.buildCompany(COMPANY);
        verify(spyParser, times(1)).buildCompany(COMPANY);
        assertEquals(company, spyParser.buildCompany(COMPANY));
        assertNotEquals(" ", spyParser.buildCompany(COMPANY));
        doThrow(new RuntimeException()).when(spyParser).buildCompany(COMPANY);
    }
}
