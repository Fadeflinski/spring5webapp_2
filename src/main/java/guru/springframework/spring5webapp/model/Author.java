package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pAuthor;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

//    public Author(String firstName, String lastName, Set<Book> books) {
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.books = books;
    }

    public Long getpAuthor() {
        return pAuthor;
    }

    public void setpAuthor(Long pAuthor) {
        this.pAuthor = pAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "pAuthor=" + pAuthor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return pAuthor != null ? pAuthor.equals(author.pAuthor) : author.pAuthor == null;
    }

    @Override
    public int hashCode() {
        return pAuthor != null ? pAuthor.hashCode() : 0;
    }
}
