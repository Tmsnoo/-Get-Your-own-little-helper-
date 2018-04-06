package pl.coderslab.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String username;
	@Size(min = 8)
	@NotNull
	private String password;
	private boolean enabled;
	@Email(message="Message z Entity")
	@Column(unique = true)
	@NotEmpty
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
	private List <Job> jobs ;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private Ukrainian ukrainian;

	public User() {
	}

	public User(String username, String password, String email) {
		super();
		this.username = username;
		setPassword(password);
		this.email = email;
	}

	public Ukrainian getUkrainain() {
		return ukrainian;
	}

	public void setUkrainian(Ukrainian ukrainian) {
		this.ukrainian = ukrainian;
	}

	

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPasswordCorrect(String password) {
		return BCrypt.checkpw(password, this.password);
	}

}