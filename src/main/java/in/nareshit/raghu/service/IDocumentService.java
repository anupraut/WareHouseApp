package in.nareshit.raghu.service;

import in.nareshit.raghu.model.Document;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {

    public void saveDocument(Document doc);

    public List<Object[]> getDocIdAndNames();

    public Optional<Document> getDocumentById(Integer id);
}
