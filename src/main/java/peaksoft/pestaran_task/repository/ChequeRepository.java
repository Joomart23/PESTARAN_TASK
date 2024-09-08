package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import peaksoft.pestaran_task.entiti.Cheque;

public interface ChequeRepository extends JpaRepository<Cheque,Long> {
}
