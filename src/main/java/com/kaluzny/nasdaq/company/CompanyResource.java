package com.kaluzny.nasdaq.company;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("companies")
public class CompanyResource {

    private CompanyService companyService;

    @Inject
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GET
    @Path("{symbol}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getCompany(@PathParam("symbol") String companySymbol) {
        Company company = new Company();
        company.setSymbolCompany(companySymbol);
        company.setExchange(companyService.getExchange(companySymbol));
        company.setSectorCompany(companyService.getSectorCompany(companySymbol));
        company.setExchangePrice(companyService.getExchangePrice(companySymbol));
        company.setMarketTime(companyService.getMarketTime(companySymbol));
        return company;
    }
}
