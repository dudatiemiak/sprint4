package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaSuspensaoBO;
import br.com.fiap.to.ProblemaSuspensaoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/problema_suspensao")
public class ProblemaSuspensaoResource {
    private ProblemaSuspensaoBO problemaSuspensaoBO = new ProblemaSuspensaoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProblemaSuspensaoTO> resultado = problemaSuspensaoBO.findAll();
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
    @Path("/{problema_suspensao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("problema_suspensao") String problema_suspensao) {
        ProblemaSuspensaoTO resultado = problemaSuspensaoBO.findByCodigo(problema_suspensao);

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
    public Response save(@Valid ProblemaSuspensaoTO prob) {
        ProblemaSuspensaoTO resultado = problemaSuspensaoBO.save(prob);

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
    @Path("/{problema_suspensao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaSuspensaoTO prob, @PathParam("problema_suspensao") String problema_suspensao) throws SQLException {
        prob.setProblema_suspensao(problema_suspensao);
        ProblemaSuspensaoTO resultado = problemaSuspensaoBO.update(prob);
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
