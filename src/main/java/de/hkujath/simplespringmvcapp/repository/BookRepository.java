package de.hkujath.simplespringmvcapp.repository;

import de.hkujath.simplespringmvcapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

   Book findByIsbn(Long isbn);
}
