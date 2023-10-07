package co.wali.nboot.modules.address;

import co.wali.nboot.modules.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
@Transactional
@Entity
@Table(name = "jpa_address")
public class Address {
    @Id
    @GeneratedValue(generator = "addr_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addr_id",
            sequenceName = "addr_sequence", initialValue = 51,
            allocationSize = 1)
    @Column(name = "addr_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    @NonNull
    private String addressType;

    @NonNull
    private String streetNo;

    @NonNull
    private String streetName;

    @NonNull
    private Integer postCode;

    @NonNull
    private String city;

    @NonNull
    private String country;

    /* // for OneToOne mapping
    @NonNull
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Student student;*/

    // for OneToMany mapping there is no need to create instance and annotation in Reference side..



}
