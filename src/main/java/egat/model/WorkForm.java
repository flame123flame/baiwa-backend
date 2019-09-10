package egat.model;

public class WorkForm {
	
	private Long workFormId;
	private Long cattegoryId;
	private String name;
	private String descripton;
	
	
	public Long getWorkFormId() {
		return workFormId;
	}
	public void setWorkFormId(Long workFormId) {
		this.workFormId = workFormId;
	}
	public Long getCattegoryId() {
		return cattegoryId;
	}
	public void setCattegoryId(Long cattegoryId) {
		this.cattegoryId = cattegoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	

}
