package nl.novi.lesvoorbeeldnamen.model;

//POJO (Plain OLd Java Object)
public class Book {

    //attributen
    private String title;
    private String author;
    private String isbn;

    //constructor is niet nodig hier (lege constructor), omdat Spring boot ervanuit gaat dat er een lege constructor
    // (default) is en dat later de attributen met getters en setters worden aangevuld. Als je wel hier wel al de
    // attributen aan de constructor wil toevoegen, zal je tevens een lege Constructor moeten toevoegen, omdat Spring
    // boot hierom vraagt (tevens vermelden in comment)

    //getters en setters
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
