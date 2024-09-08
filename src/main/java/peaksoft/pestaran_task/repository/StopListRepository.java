package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.pestaran_task.entiti.StopList;

public interface StopListRepository extends JpaRepository<StopList, Long> {
}
