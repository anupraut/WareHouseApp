package in.nareshit.raghu.repo;

import in.nareshit.raghu.model.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentTypeRepo
        extends JpaRepository<ShipmentType, Integer> {

    @Query("SELECT ST.shipmentMode, count(ST.shipmentMode) FROM ShipmentType ST GROUP BY ST.shipmentMode")
    List<Object[]> getShipmentTypeModeCount();

    @Query("SELECT id, shipmentCode from ShipmentType WHERE enableShipment='Yes'")
    List<Object[]> getEnabledShipments();
}
