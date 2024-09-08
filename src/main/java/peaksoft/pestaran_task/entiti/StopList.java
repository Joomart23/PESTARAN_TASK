package peaksoft.pestaran_task.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stopLists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stopLists_name")
    @SequenceGenerator(name = "stopLists_name", sequenceName = "stopLists_seq", allocationSize = 1)
    private Long id;
    //причина
    private String reason;
    //дата
    private String date;
    @OneToOne
    @JoinColumn(name = "menuitem_id")
    private Menultem menuItem;


}
