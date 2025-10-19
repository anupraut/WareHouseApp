package in.nareshit.raghu.repo;

import in.nareshit.raghu.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartRepository
        extends JpaRepository<Part, Integer> {

    @Query("SELECT id, partCode  FROM Part")
    List<Object[]> getPartIdAndCode();
}
