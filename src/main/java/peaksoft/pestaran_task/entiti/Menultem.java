package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "menultems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menultem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menultems_name")
    @SequenceGenerator(name = "menultems_name", sequenceName = "menultems_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String image;
    private int price;
    private String description;
    //вегетариандык болуп саналат
    private String isVegetarian;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToMany(mappedBy = "menuItems")
    private List<Cheque> cheques;
    @OneToOne(mappedBy = "menuItem")
    private StopList stopList;
    @ManyToOne
    private Subcategory subcategory;


}
