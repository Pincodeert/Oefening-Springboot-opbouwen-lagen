package nl.novi.lesvoorbeeldnamen.repository;

import nl.novi.lesvoorbeeldnamen.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Iterable<Book> findAllByTitle(String title);
    Iterable<Book> findAllByTitleContainingIgnoreCase(String title);

   @Query(value = "SELECT * FROM books b WHERE b.title LIKE %:s%", nativeQuery = true) // using SQL
   Iterable<Book> searchByTitleLike(@Param("s") String s);
}
