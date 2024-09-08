package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = "Cheques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cheques_name")
    @SequenceGenerator(name = "Cheques_name", sequenceName = "Cheques_seq", allocationSize = 1)
    private Long id;
    //орточо басы
    private int priceAverage;
    //тузулгон
    private String createdAt;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Menultem> menuItems;


}
