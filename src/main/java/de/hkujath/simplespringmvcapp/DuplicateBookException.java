package de.hkujath.simplespringmvcapp;

import de.hkujath.simplespringmvcapp.entity.Book;
import lombok.Getter;

@Getter
public class DuplicateBookException extends RuntimeException {

   private final Book book;

   public DuplicateBookException(Book book) {
      super();
      this.book = book;
   }
}