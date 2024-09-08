package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.pestaran_task.emum.Role;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_name")
    @SequenceGenerator(name = "users_name", sequenceName = "users_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate localDate;
    private String email;
    private String password;
    private String phoneNumber;
    //роль
    @Enumerated(EnumType.STRING)
    private Role role;
    //опыт
    private String expirense;
   @ManyToOne
   private Restaurant restaurant;
    @OneToMany(mappedBy = "user")
    private List<Cheque> cheques;


}
