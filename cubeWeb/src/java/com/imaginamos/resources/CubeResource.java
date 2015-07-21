/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.resources;

import com.imaginamos.delegator.CubeDelegator;
import com.imaginamos.model.Case;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Servicio rest que realiza los calculos sobre el cubo
 *
 * @author Yerson Cacua
 */
@Path("Cube")
public class CubeResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response summation(List<Case> cases) {
        CubeDelegator delegator = new CubeDelegator();
        List<String> result = delegator.processingCases(cases);
        return Response.ok(result.toString()).build();
    }
}
