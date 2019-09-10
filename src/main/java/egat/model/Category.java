package egat.model;

import java.util.List;

public class Category {
	
	private Long cattegoryId;
	private String name;
	private String descripton;
	private List<WorkForm> workFormList;
	
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
	public List<WorkForm> getWorkFormList() {
		return workFormList;
	}
	public void setWorkFormList(List<WorkForm> workFormList) {
		this.workFormList = workFormList;
	}
	
	
	

}
