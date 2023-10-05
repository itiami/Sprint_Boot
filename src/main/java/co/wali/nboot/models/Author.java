package co.wali.nboot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "jpa_author")
public class Author {
    @Id
    @GeneratedValue(generator = "author_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "author_id",
            sequenceName = "author_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "author_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    private String authorFname;
    private String authorLname;
    private String authorEmail;

    // for Math Book can be written by Many Author.
    // Same Author can wite Other Books like Physic, Higher Math etc
    // mappedBy = is use to set the Owner of this column is Other One. In this case Course Entity
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}