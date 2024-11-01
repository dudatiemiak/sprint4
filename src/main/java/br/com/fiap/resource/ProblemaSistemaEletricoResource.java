package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaSistemaEletricoBO;
import br.com.fiap.to.ProblemaSistemaEletricoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_se")
public class ProblemaSistemaEletricoResource {
    private ProblemaSistemaEletricoBO problemaSistemaEletricoBO = new ProblemaSistemaEletricoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaSistemaEletricoTO> resultado = problemaSistemaEletricoBO.findAll();
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
    @Path("/{problema_se}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_se") String problema_se) {
        ProblemaSistemaEletricoTO resultado = problemaSistemaEletricoBO.findByCodigo(problema_se);

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
    public Response save(@Valid ProblemaSistemaEletricoTO prob) {
        ProblemaSistemaEletricoTO resultado = problemaSistemaEletricoBO.save(prob);

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
    @Path("/{problema_se}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaSistemaEletricoTO prob, @PathParam("problema_se") String problema_se) throws SQLException {
        prob.setProblema_se(problema_se);
        ProblemaSistemaEletricoTO resultado = problemaSistemaEletricoBO.update(prob);
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
