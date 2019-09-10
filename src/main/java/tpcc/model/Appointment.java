package tpcc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long appointmentId;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
	@Column(name = "time_start")
	private String timeStart;
	@Column(name = "time_end")
	private String timeEnd;
	@Column(name = "date")
	private Date date;
	@Column(name = "created_by")
	private String createdBy = "tests";
	@Column(name = "created_date")
	private Date createdDate = new Date();
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private Date updatedDate;
	@Column(name = "is_deleted")
	private String isDeleted = "N";

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
