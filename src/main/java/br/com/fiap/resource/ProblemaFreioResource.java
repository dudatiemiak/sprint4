package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaFreioBO;
import br.com.fiap.to.ProblemaFreioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_freio")
public class ProblemaFreioResource {
    private ProblemaFreioBO problemaFreioBO = new ProblemaFreioBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaFreioTO> resultado = problemaFreioBO.findAll();
        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); // 200 (ok)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Path("/{problema_freio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_freio") String problema_freio) {
        ProblemaFreioTO resultado = problemaFreioBO.findByCodigo(problema_freio);

        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = Response.status(404); //404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ProblemaFreioTO prob) {
        ProblemaFreioTO resultado = problemaFreioBO.save(prob);

        Response.ResponseBuilder response = null;

        if  (resultado != null) {
            response = Response.created(null); //201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return  response.build();
    }

    @PUT
    @Path("/{problema_freio}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaFreioTO prob, @PathParam("problema_freio") String problema_freio) throws SQLException {
        prob.setProblema_freio(problema_freio);
        ProblemaFreioTO resultado = problemaFreioBO.update(prob);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); //201 CREATED
        }else {
            response = Response.status(400); //400 BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
