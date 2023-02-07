package com.distribuida.dto.bookmapper;

import com.distribuida.dto.Author;
import com.distribuida.dto.Book;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.DbRow;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class BookMp implements DbMapper<Book> {
    @Override
    public Book read(DbRow row) {
        var id = row.column("id");
        var isbn = row.column("isbn");
        var title = row.column("title");
        var price = row.column("price");
        var authorId = row.column("author_id");
        var firstName = row.column("first_name");
        var lastName = row.column("last_name");

        return new Book(
                id.as(Integer.class),
                new Author(
                        authorId.as(Integer.class),
                        firstName.as(String.class),
                        lastName.as(String.class)
                ),
                isbn.as(String.class),
                title.as(String.class),
                price.as(Double.class)
        );
    }

    @Override
    public Map<String, ?> toNamedParameters(Book value) {
        var m = new HashMap<String, Object>();
        m.put("id", value.getId());
        m.put("isbn", value.getIsbn());
        m.put("title", value.getTitle());
        m.put("price", value.getPrice());

        var author = value.getAuthor();
        m.put("authorId", author.getId());
        m.put("firstName", author.getFirstName());
        m.put("lastName", author.getLastName());

        return m;
    }

    @Override
    public List<?> toIndexedParameters(Book value) {
        ArrayList<Object> l = new ArrayList<>();
        l.add(value.getId());
        l.add(value.getIsbn());
        l.add(value.getTitle());
        l.add(value.getPrice());

        var author = value.getAuthor();
        l.add(author.getId());
        l.add(author.getFirstName());
        l.add(author.getLastName());

        return l;
    }
}
