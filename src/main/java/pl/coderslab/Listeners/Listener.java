package pl.coderslab.Listeners;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;

import pl.coderslab.Entity.Job;

public class Listener {
	@PrePersist
	public void setCreationTime(Job job) {
		job.setCreated(new Timestamp(new Date().getTime()));
	}
}

