package com.mahdi.belhaid.rest.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tsc-massyn/restapi/CONTRAT_TOPADMAS_REST_STRUC_05/ua/uaCompteBancaire")
public interface Csvaps05SynchroneInterface {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response  uaCompteBancaire(@QueryParam("codeUa") String codeUa,
                                                          @QueryParam("date") String date,
                                                          @QueryParam("codeFlux") String codeFlux
    );


}
