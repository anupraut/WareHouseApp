package in.nareshit.raghu.service;

import in.nareshit.raghu.model.ShipmentType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IShipmentTypeService {

    Integer saveShipmentType(ShipmentType st);

    List<ShipmentType> getAllShipmentTypes();

    void deleteShipmentType(Integer id);

    boolean isShipmentTypeExist(Integer id);

    Optional<ShipmentType> getOneShipmentType(Integer id);

    void updateShipmentType(ShipmentType st);

    List<Object[]> getShipmentTypeModeCount();

    Map<Integer, String> getEnabledShipments();
}
