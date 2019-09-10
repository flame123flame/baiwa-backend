package tpcc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppointmentInvite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8976992525505420123L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invite_id")
	private Long inviteId;
	
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name = "user_id_invite")
	private String userIdInvite;
	
	@Column(name = "status_invite")
	private String statusInvite;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_by")
	private String createdBy = "createdByTest";
	
	@Column(name = "created_date")
	private Date createdDate = new Date();
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "is_deleted")
	private String isDeleted = "N";

	public Long getInviteId() {
		return inviteId;
	}

	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getUserIdInvite() {
		return userIdInvite;
	}

	public void setUserIdInvite(String userIdInvite) {
		this.userIdInvite = userIdInvite;
	}

	public String getStatusInvite() {
		return statusInvite;
	}

	public void setStatusInvite(String statusInvite) {
		this.statusInvite = statusInvite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}
