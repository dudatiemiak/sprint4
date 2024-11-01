package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaTransmissaoBO;
import br.com.fiap.to.ProblemaTransmissaoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_transmissao")
public class ProblemaTransmissaoResource {
    private ProblemaTransmissaoBO problemaTransmissaoBO = new ProblemaTransmissaoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaTransmissaoTO> resultado = problemaTransmissaoBO.findAll();
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
    @Path("/{problema_transmissao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_transmissao") String problema_transmissao) {
        ProblemaTransmissaoTO resultado = problemaTransmissaoBO.findByCodigo(problema_transmissao);

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
    public Response save(@Valid ProblemaTransmissaoTO prob) {
        ProblemaTransmissaoTO resultado = problemaTransmissaoBO.save(prob);

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
    @Path("/{problema_transmissao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaTransmissaoTO prob, @PathParam("problema_transmissao") String problema_transmissao) throws SQLException {
        prob.setProblema_transmissao(problema_transmissao);
        ProblemaTransmissaoTO resultado = problemaTransmissaoBO.update(prob);
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
