package de.hkujath.simplespringmvcapp.service;

import de.hkujath.simplespringmvcapp.DuplicateBookException;
import de.hkujath.simplespringmvcapp.entity.Book;
import de.hkujath.simplespringmvcapp.repository.BookRepository;
import java.util.Collection;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

   private BookRepository bookRepository;

   @Autowired
   public BookServiceImpl(BookRepository repository) {
      this.bookRepository = repository;
   }

   @Override
   public Collection<Book> getBooks() {

      var results = bookRepository.findAll();

      results.forEach(x -> LOG.info("ISBN: {}, Title: {}, Author: {}", x.getIsbn(), x.getTitle(), x.getAuthor()));
      return results;
   }

   @Override
   public Book addBook(Book book) {
      var existingBook = this.bookRepository.findById(book.getIsbn());
      if (existingBook.isPresent()) {
         throw new DuplicateBookException(book);
      }

      var savedBook = this.bookRepository.save(book);
      return savedBook;
   }

   @Override
   public Optional<Book> findByISBN(Long isbn) {
      return bookRepository.findById(isbn);
   }


}