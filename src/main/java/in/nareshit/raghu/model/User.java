package in.nareshit.raghu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users_tab")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "usr_id_col")
    private Integer id;

    @Column(name = "usr_display_name_col")
    private String uname;
    @Column(name = "usr_email_col")
    private String email;
    @Column(name = "usr_pwd_col")
    private String pwd;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "usr_roles_tab",
            joinColumns = @JoinColumn(name = "usr_id_col")
    )
    @Column(name = "usr_roles_col")
    private Set<String> roles;

    @Column(name = "usr_active_col")
    private boolean active;

    @Column(name = "usr_otp_col")
    private String otp;

}
