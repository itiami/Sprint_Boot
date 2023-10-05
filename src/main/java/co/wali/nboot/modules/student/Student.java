package co.wali.nboot.modules.student;

import co.wali.nboot.modules.address.Address;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString

@Transactional
@Entity
@Table(name = "jpa_student")
public class Student {
    @Id
    @GeneratedValue(generator = "std_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "std_id",
            sequenceName = "std_sequence", initialValue = 101,
            allocationSize = 1)
    @Column(name = "std_id", unique = true, nullable = false,
            precision = 10, scale = 0)
    private Long id;

    @NonNull
    private Integer rollId;

    @NonNull
    private String fname;

    @NonNull
    private String lname;

    @NonNull
    //@Column(columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date dob;
    @Transient
    private Integer age;
    @NonNull
    private String cls_grade;

    @NonNull
    private String cls_section;

    @NonNull
    private String email;

    /* // for OneToOne mapping
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addr_id", referencedColumnName = "addr_id")
    private Address address;*/

    // for OneToMany mapping
    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addr_id")
    private List<Address> address;

}
