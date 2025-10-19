package in.nareshit.raghu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "order_method_tab")
public class OrderMethod {
    @Id
    @GeneratedValue(generator = "om_seq")
    @SequenceGenerator(name = "om_seq", sequenceName = "om_seq_test")
    @Column(name = "ord_id_col")
    private Integer id;
    @Column(name = "ord_mode_col")
    private String orderMode;
    @Column(name = "ord_code_col")
    private String orderCode;
    @Column(name = "ord_type_col")
    private String orderType;

    @ElementCollection
    @CollectionTable(
            name = "order_acpt_tab",
            joinColumns = @JoinColumn(name = "ord_id_col")
    )
    @Column(name = "ord_acpt_col")
    private Set<String> orderAcpt;


    @Column(name = "ord_desc_col")
    private String orderDesc;
}
