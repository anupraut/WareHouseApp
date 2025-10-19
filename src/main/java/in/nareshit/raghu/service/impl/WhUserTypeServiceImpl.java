package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.model.WhUserType;
import in.nareshit.raghu.repo.WhUserTypeRepository;
import in.nareshit.raghu.service.IWhUserTypeService;
import in.nareshit.raghu.util.AppUtil;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	
	@Autowired
	private WhUserTypeRepository repo;
	
	public Integer saveWhUserType(WhUserType whUserType) {
		return repo.save(whUserType).getId();
	}

	@Override
	public void updateWhUserType(WhUserType whUserType) {
		repo.save(whUserType);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<WhUserType> getOneWhUserType(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return repo.findAll();
	}

	@Override
	public boolean isWhUserTypeExist(Integer id) {
		return repo.existsById(id);
	}
	
	@Override
	public boolean isWhUserTypeEmailExist(String userEmail) {
		return repo.getUserMailCount(userEmail)>0;
	}

	@Override
	public List<Object[]> getUserTypeAndCount() {
		return repo.getUserTypeAndCount();
	}
	
	@Override
	public Page<WhUserType> getWhUserTypesByPage(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Map<Integer,String> getUserIdAndCodeByType(String userType) {
		List<Object[]> list = repo.getUserIdAndCodeByType(userType);
		return AppUtil.convertToMap(list);
	}
	
}
