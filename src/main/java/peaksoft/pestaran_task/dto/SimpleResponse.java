package peaksoft.pestaran_task.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleResponse {
    public HttpStatus status;
    public String message;
}
