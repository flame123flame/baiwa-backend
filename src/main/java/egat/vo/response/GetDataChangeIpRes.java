package egat.vo.response;

import java.util.List;

public class GetDataChangeIpRes {
	private Long workFormId;
	private Long cattegoryId;
	private Long userId;
	private List<FormChangeDtlRes> detail;

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

	public List<FormChangeDtlRes> getDetail() {
		return detail;
	}

	public void setDetail(List<FormChangeDtlRes> detail) {
		this.detail = detail;
	}

}
