package nl.novi.lesvoorbeeldnamen.controllers;

import nl.novi.lesvoorbeeldnamen.model.Book;
import nl.novi.lesvoorbeeldnamen.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {



    //constructor weggelaten (vanwege default lege constructor)


    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping (value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable ("id") int id){
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        Book newBook = bookRepository.save(book);

        int newId = newBook.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book){
        Book existingBook = bookRepository.findById(id).orElse(null);

        if(!book.getTitle().isEmpty()){
            existingBook.setTitle(book.getTitle());
        }
        if(!book.getAuthor().isEmpty()){
            existingBook.setAuthor(book.getAuthor());
        }
        if(!book.getIsbn().isEmpty()){
            existingBook.setIsbn(book.getIsbn());
        }

        bookRepository.save(existingBook);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "books/{id}")
    public ResponseEntity<Object> partialUpdateBook(@PathVariable int id, @RequestBody Book book){
        Book existingBook = bookRepository.findById(id).orElse(null);

        if(!(book.getTitle() == null) && !book.getTitle().isEmpty()){
            existingBook.setTitle(book.getTitle());
        }
        if(!(book.getAuthor() == null) && !book.getAuthor().isEmpty()){
            existingBook.setAuthor(book.getAuthor());
        }
        if(!(book.getIsbn() == null) && !book.getIsbn().isEmpty()){
            existingBook.setIsbn(book.getIsbn());
        }

        bookRepository.save(existingBook);

        return ResponseEntity.noContent().build();
    }

}
