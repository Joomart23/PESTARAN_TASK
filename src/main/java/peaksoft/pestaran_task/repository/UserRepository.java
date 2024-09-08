package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.user.UserRequest;
import peaksoft.pestaran_task.entiti.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
