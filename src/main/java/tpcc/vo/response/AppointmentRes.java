package tpcc.vo.response;

import org.springframework.stereotype.Service;

@Service
public class AppointmentRes {

	private Long appointmentId;
	private String title;
	private String description;
	private String appointment;
	private String status;
	private String timeStart;
	private String timeEnd;
	private String date;
	private String createdBy;
	
	
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
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
