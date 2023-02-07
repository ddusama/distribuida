package com.distribuida.dao;

import com.distribuida.dto.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorDao implements PanacheRepository<Author> {
}
