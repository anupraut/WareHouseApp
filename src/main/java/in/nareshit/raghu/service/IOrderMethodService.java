package in.nareshit.raghu.service;

import in.nareshit.raghu.model.OrderMethod;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IOrderMethodService {

    Integer saveOrderMethod(OrderMethod om);

    List<OrderMethod> getAllOrderMethods();

    void deleteOrderMethod(Integer id);

    boolean isOrderMethodExist(Integer id);

    Optional<OrderMethod> getOneOrderMethod(Integer id);

    void updateOrderMethod(OrderMethod om);

    boolean isOrderMethodExistByCode(String orderCode);

    Map<Integer, String> getOrderMethodIdAndCode(String mode);

}
