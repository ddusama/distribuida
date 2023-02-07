package com.distribuida.srv;

import com.distribuida.dto.Book;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BookSrv {
    Book listarUno(int id) throws ExecutionException, InterruptedException;
    List<Book> listarTodo() throws ExecutionException, InterruptedException;
    long crear(Book book);
    long actualizar(Book book);
    long eliminar(int id);
}