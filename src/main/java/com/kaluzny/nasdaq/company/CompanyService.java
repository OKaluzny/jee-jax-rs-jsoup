package com.kaluzny.nasdaq.company;

import com.kaluzny.nasdaq.interceptor.Logged;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
@Logged
@Slf4j
public class CompanyService {

    private static final String URL_FORMAT = "https://old.nasdaq.com/symbol/%s/real-time";
    private static final String USER_AGENT = "chrome";
    private static final String EXCHANGE_LABEL = "qbar_exchangeLabel";
    private static final String SECTOR_LABEL = "qbar_sectorLabel";
    private static final String DWIDGET_DOLLAR = "qwidget-dollar";
    private static final String DWIDGET_MARKETTIME = "qwidget_markettime";

    private Document document;
    private Element element;

    @Logged
    public Document getDocument(String company) throws IOException {
        log.info("getDocument() - start: company = {}", company);
        String url = String.format(URL_FORMAT, company);
        document = Jsoup.connect(url).userAgent(USER_AGENT).get();
        log.info("getDocument() - end: document = {}", document);
        return document;
    }

    @Logged
    public String getExchange(String company) {
        log.info("getExchange() - start: company = {}", company);
        try {
            document = getDocument(company);
            element = document.getElementById(EXCHANGE_LABEL);
            log.info("getExchange() - end: document = {}, element = {}", document, element);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse an exchange.", exception);
        }
        log.info(String.format(">>> Gets the name an exchange: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getSectorCompany(String company) {
        log.info("getSectorCompany() - start: company = {}", company);
        try {
            document = getDocument(company);
            element = document.getElementById(SECTOR_LABEL);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse sector.", exception);
        }
        log.info(String.format(">>> Gets the name a sector: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getExchangePrice(String company) {
        log.info("getExchangePrice() - start: company = {}", company);
        try {
            document = getDocument(company);
            element = document.getElementsByClass(DWIDGET_DOLLAR).first();
        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        log.info(String.format(">>> Gets the stock quotes: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getMarketTime(String company) {
        log.info("getMarketTime() - start: company = {}", company);
        try {
            document = getDocument(company);
            element = document.getElementById(DWIDGET_MARKETTIME);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        log.info(String.format(">>> Gets the date as of: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public Company buildCompany(String companySymbol) {
        log.info("buildCompany() - start: companySymbol = {}", companySymbol);
        Company company = new Company();
        company.setSymbolCompany(companySymbol);
        company.setExchange(getExchange(companySymbol));
        company.setSectorCompany(getSectorCompany(companySymbol));
        company.setExchangePrice(getExchangePrice(companySymbol));
        company.setMarketTime(getMarketTime(companySymbol));
        log.info("buildCompany() - end: company = {}", company);
        return company;
    }
}
