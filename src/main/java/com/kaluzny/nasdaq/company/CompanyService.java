package com.kaluzny.nasdaq.company;

import com.kaluzny.nasdaq.CompanyException;
import com.kaluzny.nasdaq.interceptor.Logged;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.logging.Logger;

@ApplicationScoped
@Logged
public class CompanyService {
    private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());
    private static final String URL_FORMAT = "http://www.nasdaq.com/symbol/%s/real-time";
    private static final String USER_AGENT = "Chrome";
    private Document document;
    private Element element;

    @Logged
    public Document parse(String company) throws IOException {
        String url = String.format(URL_FORMAT, company);
        LOGGER.info(String.format(">>> Connection to the: '%s'.", company));
        return Jsoup.connect(url).userAgent(USER_AGENT).get();
    }

    @Logged
    public String getExchange(String company) {
        try {
            document = parse(company);
            element = document.getElementById("qbar_exchangeLabel");

        } catch (IOException exception) {
            throw new CompanyException("Could not parse an exchange.", exception);
        }
        LOGGER.info(String.format(">>> Gets the name an exchange: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getNameCompany(String company) {
        try {
            document = parse(company);
            element = document.getElementById("qwidget_pageheader").firstElementSibling();

        } catch (IOException exception) {
            throw new CompanyException("Could not parse a name company.", exception);
        }
        LOGGER.info(String.format(">>> Gets the name a company is: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getSectorCompany(String company) {
        try {
            document = parse(company);
            element = document.getElementById("qbar_sectorLabel");

        } catch (IOException exception) {
            throw new CompanyException("Could not parse sector.", exception);
        }
        LOGGER.info(String.format(">>> Gets the name a sector: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getStockQuotes(String company) {
        try {
            document = parse(company);
            element = document.getElementsByClass("qwidget-dollar").first();

        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        LOGGER.info(String.format(">>> Gets the stock quotes: '%s'.", element.text()));
        return element.text();
    }

    @Logged
    public String getDataAsOf(String company) {
        try {
            document = parse(company);
            element = document.getElementById("qwidget_markettime");

        } catch (IOException exception) {
            throw new CompanyException("Could not parse company.", exception);
        }
        LOGGER.info(String.format(">>> Gets the data as of: '%s'.", element.text()));
        return element.text();
    }
}