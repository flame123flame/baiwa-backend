package tpcc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import baiwa.bean.ResponseData;
import baiwa.util.constant.ProjectConstant.RESPONSE_MESSAGE;
import baiwa.util.constant.ProjectConstant.RESPONSE_STATUS;
import tpcc.model.Appointment;
import tpcc.service.AppointmentService;
import tpcc.vo.request.AppointmentReq;
import tpcc.vo.response.AppointmentRes;

@Controller
@RequestMapping("api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@PostMapping("/get_all")
	@ResponseBody
	public ResponseData<List<AppointmentRes>> listdata() {
		ResponseData<List<AppointmentRes>> responseData = new ResponseData<List<AppointmentRes>>();
		try {
			responseData.setData(appointmentService.getAppointmentList());
	
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("RoleController::listdata ", e);
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}
	@PostMapping("/get_by_id")
	@ResponseBody
	public ResponseData<AppointmentRes> findById(@RequestBody AppointmentReq form) {
		ResponseData<AppointmentRes> responseData = new ResponseData<AppointmentRes>();
		try {
			responseData.setData(appointmentService.findById(form));
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("RoleController::findById ", e);
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public ResponseData<?> saveAppointment(@RequestBody AppointmentReq form) {
		ResponseData<?> responseData = new ResponseData<>();
		try {
			appointmentService.saveAppointment(form);
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("RoleController::saveRole ", e);
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.FAILED);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}
	
	
	@PostMapping("/edit")
	@ResponseBody
	public ResponseData<Appointment> EditAppointment(@RequestBody AppointmentReq form) {
		ResponseData<Appointment> responseData = new ResponseData<Appointment>();
		try {
			responseData.setData(appointmentService.editAppointment(form));			
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("RoleController::saveRole ", e);
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.FAILED);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}
 
}
