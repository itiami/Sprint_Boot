package co.wali.nboot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "jpa_course")
public class Course {
    @Id
    @GeneratedValue(generator = "course_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_id",
            sequenceName = "course_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "course_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    private String courseTitle;
    private String courseDesctiption;

    @ManyToMany
    @JoinTable(
            name = "authorCourses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    // One Course has Too Many Section. i.e a list of sections
    @OneToMany(mappedBy = "course")
    private List<Section> sectionList;
}