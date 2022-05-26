package nl.novi.lesvoorbeeldnamen.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    //attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int id; // dit attribuut is puur voor de database nodig om een privatekey te kunnen aanmaken

    private String title;
    private String author;
    private String isbn;

    //constructor is niet nodig hier voor Spring boot (Default constructor = lege constructor), omdat Spring boot ervanuit gaat dat er een lege constructor
    // (default) is en dat later de attributen met getters en setters worden aangevuld. Als je wel hier wel al de
    // attributen aan de constructor wil toevoegen, zal je tevens een lege Constructor moeten toevoegen, omdat Spring
    // boot hierom vraagt (tevens vermelden in comment)

    //default constructor
    public Book(){}

    // Mogelijk gewenste contructor. Als je deze nodig hebt, moet je in Spring boot tevens de default (lege) constructor
    // aanmaken, alsook de full constructor)
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    //full constructor
    public Book(int id, String title, String author, String isbn){
        this.id = id;
        this.author = author;
        this.isbn = isbn;
    }


    //getters en setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}
