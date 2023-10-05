package co.wali.nboot.models;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "jpa_resources")
public class Resources {
    @Id
    @GeneratedValue(generator = "res_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "res_id",
            sequenceName = "res_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "res_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    private String resName;
    private String resSize;
    private String resUrl;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
