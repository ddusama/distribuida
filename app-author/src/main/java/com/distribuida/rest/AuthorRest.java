package com.distribuida.rest;

import com.distribuida.dto.Author;
import com.distribuida.srv.AuthorSrv;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/author")
public class AuthorRest {

    @Inject
    AuthorSrv authorSrv;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Author get(@PathParam("id") Long id) {
        return authorSrv.listarUno(id);
    }
    @GET
    @Produces("application/json")
    public List<Author> list() {
        return authorSrv.listarTodo();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Author author) {
        try {
            authorSrv.crear(author);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al guardar").build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, Author author) throws Exception {
        try {
            authorSrv.actualizar(id, author);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al actualizar" + ex.getMessage()).build();
        }
        return Response.status((Response.Status.OK)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        try {
            authorSrv.eliminar(id);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al eliminar author").build();
        }
        return Response.status((Response.Status.OK)).build();
    }

}
