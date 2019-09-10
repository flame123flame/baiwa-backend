package baiwa.bean;

import java.util.List;

import baiwa.util.constant.ProjectConstant.RESPONSE_STATUS;
import tpcc.model.Appointment;
import tpcc.vo.response.AppointmentRes;

public class ResponseData<T> {

	private RESPONSE_STATUS status = RESPONSE_STATUS.FAILED;
	private String message;
	private T data;

	public RESPONSE_STATUS getStatus() {
		return status;
	}

	public void setStatus(RESPONSE_STATUS status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}






}
