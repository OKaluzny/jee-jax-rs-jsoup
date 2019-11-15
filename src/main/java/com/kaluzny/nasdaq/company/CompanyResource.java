package com.kaluzny.nasdaq.company;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("companies")
@RequiredArgsConstructor
public class CompanyResource {

    private final CompanyService companyService;

    @GET
    @Path("{symbol}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompany(@PathParam("symbol") String companySymbol) {
        companyService.buildCompany(companySymbol);
        return Response.ok().build();
    }
}

