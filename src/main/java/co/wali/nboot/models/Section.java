package co.wali.nboot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "jpa_section")
public class Section {
    @Id
    @GeneratedValue(generator = "section_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "section_id",
            sequenceName = "section_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "section_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    private String sectionName;
    private String sectionOrder;

    // Many Section belongs to One Course  = ManyToOne
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
