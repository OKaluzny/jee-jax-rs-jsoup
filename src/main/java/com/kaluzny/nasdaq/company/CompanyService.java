package com.kaluzny.nasdaq.company;

import com.kaluzny.nasdaq.CompanyException;
import com.kaluzny.nasdaq.interceptor.Logged;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
@Logged
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);
    private static final String URL_FORMAT = "http://www.nasdaq.com/symbol/%s/real-time";
    private static final String USER_AGENT = "Chrome";
    private static final String EXCHANGE_LABEL = "qbar_exchangeLabel";
    private static final String SECTOR_LABEL = "qbar_sectorLabel";
    private static final String DWIDGET_DOLLAR = "qwidget-dollar";
    private static final String DWIDGET_MARKETTIME = "qwidget_markettime";
    private Document document;
    private Element element;

    @Logged
    public Document getDocument(String company) throws IOException {
        String url = String.format(URL_FORMAT, company);
        document = Jsoup.connect(url).userAgent(USER_AGENT).get();
        LOGGER.info(String.format(">>> Connection to the: '%s'.", company));
        return document;
    }

    @Logged
    public String getExchange(String company) {
        try {
            document = getDocument(company);
            element = document.getElementById(EXCHANGE_LABEL);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse an exchange.", exception);
        }
        LOGGER.info(String.format(">>> Gets the name an exchange: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getSectorCompany(String company) {
        try {
            document = getDocument(company);
            element = document.getElementById(SECTOR_LABEL);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse sector.", exception);
        }
        LOGGER.info(String.format(">>> Gets the name a sector: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getExchangePrice(String company) {
        try {
            document = getDocument(company);
            element = document.getElementsByClass(DWIDGET_DOLLAR).first();
        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        LOGGER.info(String.format(">>> Gets the stock quotes: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getMarketTime(String company) {
        try {
            document = getDocument(company);
            element = document.getElementById(DWIDGET_MARKETTIME);
        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        LOGGER.info(String.format(">>> Gets the date as of: '%s'.", element.text()));
        return element.text();
    }
}