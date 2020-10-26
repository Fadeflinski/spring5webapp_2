package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pBook;
    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_pBook"),
            inverseJoinColumns = @JoinColumn(name = "author_pAuthor"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

//    public Book(String title, String isbn, Set<Author> autors) {
    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
//        this.authors = autors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAutors() {
        return authors;
    }

    public void setAutors(Set<Author> autors) {
        this.authors = autors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pBook=" + pBook +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return pBook != null ? pBook.equals(book.pBook) : book.pBook == null;
    }

    @Override
    public int hashCode() {
        return pBook != null ? pBook.hashCode() : 0;
    }
}
