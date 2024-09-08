package peaksoft.pestaran_task.dto.user;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
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
