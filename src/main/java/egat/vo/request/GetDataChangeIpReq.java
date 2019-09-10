package egat.vo.request;

public class GetDataChangeIpReq {
	private Long workFormId;
	private Long cattegoryId;
	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
