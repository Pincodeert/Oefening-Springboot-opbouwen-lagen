package nl.novi.lesvoorbeeldnamen.repository;

import nl.novi.lesvoorbeeldnamen.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {


}
