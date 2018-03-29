package pl.coderslab.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.coderslab.Listeners.Listener;

@EntityListeners(Listener.class)
@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 20)
	private String title;

	@NotNull
	@Size(max = 200)
	private String description;
	
	@Digits(fraction = 0, integer = 14)
	private Long telNo;

	
	private Integer rateHour;

	@NotNull
	private String city;

	@NotNull
	private String voivodeship;


	private Timestamp created;
	@ManyToOne
	@JoinColumn(name = "User_id")
	private User user;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
    private List<Category> categories;

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTelNo() {
		return telNo;
	}

	public void setTelNo(Long telNo) {
		this.telNo = telNo;
	}

	public Integer getRateHour() {
		return rateHour;
	}

	public void setRateHour(Integer rateHour) {
		this.rateHour = rateHour;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVoivodeship() {
		return voivodeship;
	}

	public void setVoivodeship(String voivodeship) {
		this.voivodeship = voivodeship;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp timestamp) {
		this.created = timestamp;
	}

}
