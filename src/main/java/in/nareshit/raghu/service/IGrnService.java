package in.nareshit.raghu.service;

import java.util.List;
import java.util.Optional;

import in.nareshit.raghu.model.Grn;
import in.nareshit.raghu.model.GrnDtl;

public interface IGrnService {

	String saveGrn(Grn grn);
	List<Grn> getAllGrns();
	Optional<Grn> getOneGrn(Integer id);
	//screen#2
	void saveGrnDtl(GrnDtl dtl);
	List<GrnDtl> getAllGrnDtlByGrnId(Integer id);
	void updateGrnDtlStatusById(String status, Integer dtlId);	
}
