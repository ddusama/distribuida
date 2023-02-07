package com.distribuida.rest;

import com.distribuida.dto.Book;
import com.distribuida.srv.BookSrv;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
@Path("/book")
public class BookRest {
    @Inject
    private BookSrv bookSrv;

    // listar uno
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Book listarUno(@PathParam("id") int id) throws ExecutionException, InterruptedException {
        return this.bookSrv.listarUno(id);
    }

    // listar todos
    @GET
    @Produces("application/json")
    public List<?> listarTodo() throws ExecutionException, InterruptedException {
        return this.bookSrv.listarTodo();
    }

    // crear
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Map<String, Long> crear(Book book) {
        return Map.of("rowsChanged", this.bookSrv.crear(book));
    }

    //actualizar
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Map<String, Long> actualizar(Book book) {
        return Map.of("rowsChanged", this.bookSrv.actualizar(book));
    }

    //eliminar
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Map<String, Long> eliminar(@PathParam("id") int id) {
        return Map.of("rowsChanged", this.bookSrv.eliminar(id));
    }
}
