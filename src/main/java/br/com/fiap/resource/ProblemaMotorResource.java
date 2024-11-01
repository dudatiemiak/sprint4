package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaMotorBO;
import br.com.fiap.to.ProblemaMotorTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_motor")
public class ProblemaMotorResource {
    private ProblemaMotorBO problemaMotorBO = new ProblemaMotorBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaMotorTO> resultado = problemaMotorBO.findAll();
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
    @Path("/{problema_motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_motor") String problema_motor) {
        ProblemaMotorTO resultado = problemaMotorBO.findByCodigo(problema_motor);

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
    public Response save(@Valid ProblemaMotorTO prob) {
        ProblemaMotorTO resultado = problemaMotorBO.save(prob);

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
    @Path("/{problema_motor}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaMotorTO prob, @PathParam("problema_motor") String problema_motor) throws SQLException {
        prob.setProblema_motor(problema_motor);
        ProblemaMotorTO resultado = problemaMotorBO.update(prob);
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
