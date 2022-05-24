package nl.novi.lesvoorbeeldnamen.controllers;

import nl.novi.lesvoorbeeldnamen.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //attribute
    private List<Book> books = new ArrayList<>();

    //constructor
    public BookController(){
        Book book1 = new Book();
        book1.setTitle("Harry Potter");
        book1.setAuthor("Rowling");
        book1.setIsbn("12345");
        books.add(book1);

        Book book2 = new Book();
        book2.setTitle("Harry Potter, deel 2");
        book2.setAuthor("Rowling");
        book2.setIsbn("67890");
        books.add(book2);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(){
            return ResponseEntity.ok(books);
    }

    @GetMapping (value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        return ResponseEntity.ok(books.get(id));
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable ("id") int id){
        books.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        books.add(book);

        int newId = books.size() - 1;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book){
        books.set(id, book);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<Object> partialUpdateBook(@PathVariable int id, @RequestBody Book book){
        Book existingBook = books.get(id);
        if(!book.getTitle().isEmpty()){
            existingBook.setTitle(book.getTitle());
        }
        if(!book.getAuthor().isEmpty()){
            existingBook.setAuthor(book.getAuthor());
        }
        if(!book.getIsbn().isEmpty()){
            existingBook.setIsbn(book.getIsbn());
        }
        books.set(id, existingBook);
        return ResponseEntity.noContent().build();
    }


}
