package nl.novi.lesvoorbeeldnamen.controllers;

import nl.novi.lesvoorbeeldnamen.model.Book;
import nl.novi.lesvoorbeeldnamen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(@RequestParam(name="title", defaultValue="") String title){
        return ResponseEntity.ok(bookService.getBooks(title));
    }

    @GetMapping (value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable ("id") int id){
        bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        int newId =bookService.addBook(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "books/{id}")
    public ResponseEntity<Object> partialUpdateBook(@PathVariable int id, @RequestBody Book book){
        bookService.partialUpdateBook(id,book);
        return ResponseEntity.noContent().build();
    }

}
