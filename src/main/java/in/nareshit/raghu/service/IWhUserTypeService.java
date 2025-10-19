package in.nareshit.raghu.service;

import in.nareshit.raghu.model.WhUserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IWhUserTypeService {

    Integer saveWhUserType(WhUserType whUserType);

    void updateWhUserType(WhUserType whUserType);

    void deleteWhUserType(Integer id);

    Optional<WhUserType> getOneWhUserType(Integer id);

    List<WhUserType> getAllWhUserTypes();

    boolean isWhUserTypeExist(Integer id);

    boolean isWhUserTypeEmailExist(String userEmail);

    List<Object[]> getUserTypeAndCount();

    Page<WhUserType> getWhUserTypesByPage(Pageable pageable);

    Map<Integer, String> getUserIdAndCodeByType(String userType);

}
