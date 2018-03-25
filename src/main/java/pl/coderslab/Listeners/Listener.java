package pl.coderslab.Listeners;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;

import pl.coderslab.Entity.Work;

public class Listener {
	@PrePersist
	public void setCreationTime(Work work) {
		work.setCreated(new Timestamp(new Date().getTime()));
		System.out.println(work.getCreated());
	}
}

