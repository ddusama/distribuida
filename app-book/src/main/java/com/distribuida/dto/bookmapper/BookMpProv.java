package com.distribuida.dto.bookmapper;

import com.distribuida.dto.Book;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.spi.DbMapperProvider;

import java.util.Optional;

public class BookMpProv implements DbMapperProvider {
    public static final BookMp MAPPER = new BookMp();

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<DbMapper<T>> mapper(Class<T> type) {
        return type.equals(Book.class) ? Optional.of((DbMapper<T>) MAPPER) : Optional.empty();
    }
}
