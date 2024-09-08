package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Subcategorys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Subcategorys_name")
    @SequenceGenerator(name = "Subcategorys_name", sequenceName = "Subcategorys_seq", allocationSize = 1)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "subcategory")
    private List<Menultem> menuItems;
    @ManyToOne
    private Category category;

}
