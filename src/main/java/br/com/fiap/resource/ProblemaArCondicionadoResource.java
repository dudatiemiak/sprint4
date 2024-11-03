package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaArCondicionadoBO;
import br.com.fiap.to.ProblemaArCondicionadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_ar")
public class ProblemaArCondicionadoResource {
    private ProblemaArCondicionadoBO problemaArCondicionadoBO = new ProblemaArCondicionadoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaArCondicionadoTO> resultado = problemaArCondicionadoBO.findAll();
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
    @Path("/{problema_ar}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_ar") String problema_ar) {
        ProblemaArCondicionadoTO resultado = problemaArCondicionadoBO.findByCodigo(problema_ar);

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
    public Response save(@Valid ProblemaArCondicionadoTO prob) {
        ProblemaArCondicionadoTO resultado = problemaArCondicionadoBO.save(prob);

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
    @Path("/{problema_ar}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaArCondicionadoTO prob, @PathParam("problema_ar") String problema_ar) throws SQLException {
        prob.setProblema_ar(problema_ar);
        ProblemaArCondicionadoTO resultado = problemaArCondicionadoBO.update(prob);
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
