package tpcc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private Long newsId;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;	
	@Column(name = "image")
	private String image;	
	@Column(name = "startdate")
	private Date startdate;
	@Column(name = "enddate")
	private Date enddate;
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
	
	
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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
