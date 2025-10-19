package in.nareshit.raghu.repo;

import in.nareshit.raghu.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository
        extends JpaRepository<Document, Integer> {

    @Query("SELECT docId,docName FROM Document ")
    List<Object[]> getDocIdAndNames();
}
