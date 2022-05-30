package nl.novi.lesvoorbeeldnamen.service;

import nl.novi.lesvoorbeeldnamen.exception.RecordNotFoundException;
import nl.novi.lesvoorbeeldnamen.model.Book;
import nl.novi.lesvoorbeeldnamen.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getBooks(){

        return bookRepository.findAll();
    }

    public Book getBook(int id){

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            return optionalBook.get();
        } else {
            //exception
            throw new RecordNotFoundException("ID does not exist!");
        }

    }

    public void removeBook(int id){

        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist");
        }

    }

    public int addBook(Book book){
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    public void updateBook(int id, Book book){
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
    }

    public void partialUpdateBook(int id, Book book){
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
    }

}
