package co.wali.nboot.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "jpa_lecture")
public class Lecture {
    @Id
    @GeneratedValue(generator = "lecture_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lecture_id",
            sequenceName = "lecture_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "lecture_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    private String lectureName;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resources resources;
}