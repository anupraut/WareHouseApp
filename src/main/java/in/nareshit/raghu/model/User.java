package in.nareshit.raghu.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users_tab")
public class User {
	@Id
	@GeneratedValue
	@Column(name="usr_id_col")
	private Integer id;
	
	@Column(name="usr_display_name_col")
	private String uname;
	@Column(name="usr_email_col")
	private String email;
	@Column(name="usr_pwd_col")
	private String pwd;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="usr_roles_tab",
			joinColumns = @JoinColumn(name="usr_id_col")
			)
	@Column(name="usr_roles_col")
	private Set<String> roles;
	
	@Column(name="usr_active_col")
	private boolean active;
	
	@Column(name="usr_otp_col")
	private String otp;
	
}
