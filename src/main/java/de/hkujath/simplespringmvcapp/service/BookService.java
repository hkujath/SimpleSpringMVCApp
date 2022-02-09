package de.hkujath.simplespringmvcapp.service;

import de.hkujath.simplespringmvcapp.entity.Book;
import java.util.Collection;
import java.util.Optional;

public interface BookService {

   Collection<Book> getBooks();

   Book addBook(Book book);

   Optional<Book> findByISBN(Long isbn);
}
