package ticketing.provide.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ev_details")
public class EvModel {


	@Column(name="xid")
	private String xid;
	@Column(name="evid_type")
	private String evIdType;
	@Id
	@Column(name="evId_value")
	private String evIdValue;
	
	public String getXid() {
		return xid;
	}
	public void setXid(String xid) {
		this.xid = xid;
	}
	public String getEvIdType() {
		return evIdType;
	}
	public void setEvIdType(String evIdType) {
		this.evIdType = evIdType;
	}
	public String getEvIdValue() {
		return evIdValue;
	}
	public void setEvIdValue(String evIdValue) {
		this.evIdValue = evIdValue;
	}
}
