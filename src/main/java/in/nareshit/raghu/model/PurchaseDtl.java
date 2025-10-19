package in.nareshit.raghu.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "po_dtl_tab")
public class PurchaseDtl {
    @Id
    @GeneratedValue
    @Column(name = "po_dtl_id_col")
    private Integer id;

    @Column(name = "po_dtl_qty_col")
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "part_id_fk_col")
    private Part part;

    @ManyToOne
    @JoinColumn(name = "po_order_id_fk_col")
    private PurchaseOrder po;

}
