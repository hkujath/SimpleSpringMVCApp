package de.hkujath.simplespringmvcapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

   @NotNull
   @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "isbn")
   @Min(1)
   private Long isbn;

   @NotBlank
   @Column(name = "title", nullable = false)
   private String title;

   @NotBlank
   @Column(name = "author", nullable = false)
   private String author;

   /**
    * Constructor
    *
    * @param title
    * @param author
    */
   public Book(String title, String author) {
      this.title = title;
      this.author = author;
   }

   /**
    * Copy constructor
    *
    * @param book
    */
   public Book(Book book) {
      this.isbn = book.getIsbn();
      this.title = book.getTitle();
      this.author = book.getAuthor();
   }

   @Override
   public String toString() {
      return getClass().getSimpleName() + "(" + "isbn = " + isbn + ", " + "title = " + title + ", " + "author = " + author + ")";
   }

}
