package de.hkujath.simplespringmvcapp.controller;

import de.hkujath.simplespringmvcapp.entity.Book;
import de.hkujath.simplespringmvcapp.service.BookService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/book")
public class BookController {

   private final BookService bookService;

   public BookController(BookService bookService) {
      this.bookService = bookService;
   }

   @GetMapping("/viewBooks")
   public String viewBooks(Model model) {
      model.addAttribute("books", this.bookService.getBooks());
      return "view-books";
   }

   @GetMapping("/addBook")
   public String addBookView(Model model) {
      model.addAttribute("book", new Book());
      return "add-book";
   }

   @PostMapping("/addBook")
   public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

      // Handle validation errors
      if (bindingResult.hasErrors()) {
        return "add-book";
      }
      //Check if book is already added
      var tmpBook = this.bookService.findByISBN(book.getIsbn());
      if (tmpBook.isPresent()) {
         return "add-book";
      }

      //add the book
      var createdBook = bookService.addBook(book);

      redirectAttributes.addFlashAttribute("savedBook", createdBook);
      redirectAttributes.addFlashAttribute("addBookSuccess", true);

      return "redirect:/viewBooks";
   }
}
