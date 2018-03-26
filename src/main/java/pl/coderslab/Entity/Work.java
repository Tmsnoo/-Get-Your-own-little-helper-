package pl.coderslab.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.coderslab.Listeners.Listener;

@EntityListeners(Listener.class)
@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 20)
	private String title;

	@NotNull
	@Size(max = 200)
	private String description;

	@Size(min = 6, max = 15)
	private int telNo;

	@NotEmpty
	private int rateHour;

	@NotNull
	private String city;

	@NotNull
	private String voivodeship;

	private Timestamp created;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

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

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public int getRateHour() {
		return rateHour;
	}

	public void setRateHour(int rateHour) {
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
