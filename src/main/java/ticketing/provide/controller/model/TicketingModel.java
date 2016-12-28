package ticketing.provide.controller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="TICKETING_PAYLOAD")
public class TicketingModel {

	@Id
	@Column(name="CANONNICALID")
	private String canonnicalId;
	
	@Lob
	@Column(name="CANONNICALDATA")
	private String canonnicalData;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public TicketingModel(){
		
	}
	
	public String getCanonnicalId() {
		return canonnicalId;
	}
	public void setCanonnicalId(String canonnicalId) {
		this.canonnicalId = canonnicalId;
	}
	
	public String getCanonnicalData() {
		return canonnicalData;
	}
	public void setCanonnicalData(String canonnicalData) {
		this.canonnicalData = canonnicalData;
	}
	
	
}
