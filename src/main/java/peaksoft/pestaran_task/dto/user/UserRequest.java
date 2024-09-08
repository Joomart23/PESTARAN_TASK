package peaksoft.pestaran_task.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate localDate;
    private String email;
    private String password;
    private String phoneNumber;
    //роль
    private String role;
    //опыт
    private String expirense;
}
