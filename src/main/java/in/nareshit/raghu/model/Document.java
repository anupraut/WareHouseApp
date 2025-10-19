package in.nareshit.raghu.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doc_tab")
public class Document {
    @Id
    @Column(name = "doc_id_col")
    private Integer docId;
    @Column(name = "doc_name_col")
    private String docName;

    @Column(name = "doc_data_col")
    @Lob // byte[] + LOB = BLOB
    private byte[] docData;
}
