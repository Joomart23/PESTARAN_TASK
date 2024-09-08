package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurants_name")
    @SequenceGenerator(name = "restaurants_name", sequenceName = "restaurants_seq", allocationSize = 1)
    private Long id;
    private String name;
    //жайгашкан жери
    private String location;
    //эс алуу түрү
    private String restType;
    //Кызматкерлердин саны
    private String numberOfEmployees;
    //услуга
    private String service;
    @OneToMany(mappedBy = "restaurant")
    private List<User> user;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menultem> menuItems;
}
