package in.nareshit.raghu.service;

import java.util.List;
import java.util.Optional;

import in.nareshit.raghu.model.Document;

public interface IDocumentService {

	public void saveDocument(Document doc);
	public List<Object[]> getDocIdAndNames();
	public Optional<Document> getDocumentById(Integer id);
}
