package com.distribuida.srv;

import com.distribuida.dto.Author;
import com.distribuida.dao.AuthorDao;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorSrvImpl implements AuthorSrv {

    @Inject
    AuthorDao authorDao;
    @Override
    public Author listarUno(Long id) {
        return authorDao.findById(id);
    }
    @Override
    public List<Author> listarTodo() {
        return authorDao.findAll().stream().toList();
    }
    @Override
    @Transactional
    public void crear(Author author) {
        authorDao.persist(author);
    }

    @Override
    @Transactional
    public void actualizar(long id, Author author) {
        Author authorDb = authorDao.findById(id);
        if (authorDb != null) {
            authorDb.setFirstName(author.getFirstName());
            authorDb.setLastName(author.getLastName());
            authorDao.persistAndFlush(authorDb);
        }
    }
    @Override
    @Transactional
    public void eliminar(Long id) {
        Author authorDb = authorDao.findById(id);
        if (authorDb != null) {
            authorDao.delete(authorDb);
        }
    }
}
