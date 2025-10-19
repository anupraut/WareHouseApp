package in.nareshit.raghu.repo;

import in.nareshit.raghu.model.OrderMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderMethodRepository
        extends JpaRepository<OrderMethod, Integer> {

    @Query("SELECT COUNT(om.orderCode) FROM OrderMethod om WHERE om.orderCode=:orderCode")
    public Integer getOrderMethodCountByCode(String orderCode);

    @Query("SELECT id,orderCode FROM OrderMethod WHERE orderMode=:mode")
    List<Object[]> getOrderMethodIdAndCode(String mode);
}
