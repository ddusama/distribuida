package com.distribuida.srv;

import com.distribuida.dto.Author;
import java.util.List;

public interface AuthorSrv {

    Author listarUno(Long id);
    List<Author> listarTodo();
    void crear(Author author);
    void actualizar(long id, Author author) throws Exception;
    void eliminar(Long id);

}
