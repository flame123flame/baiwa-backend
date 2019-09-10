package tpcc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baiwa.module.admin.model.FwUsers;
import baiwa.module.admin.vo.request.UsersReq;
import baiwa.util.ConvertDateUtils;
import tpcc.dao.jpa.AppointmentInviteReposity;
import tpcc.dao.jpa.AppointmentRepository;
import tpcc.model.Appointment;
import tpcc.model.AppointmentInvite;
import tpcc.vo.request.AppointmentReq;
import tpcc.vo.response.AppointmentRes;

@Service
public class AppointmentService {

private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentInviteReposity appointmentInviteReposity;

	
	public List<AppointmentRes> getAppointmentList( ) {
		logger.info("getAppointList");
		List<Appointment> listFind = appointmentRepository.findAll();
		List<AppointmentRes> newList = new ArrayList<>();
		AppointmentRes appoint = null;
		for (Appointment appointFind : listFind) {
			appoint = new AppointmentRes();
			appoint.setAppointmentId(appointFind.getAppointmentId());
			appoint.setTitle(appointFind.getTitle());
			appoint.setDescription(appointFind.getDescription());	
			appoint.setStatus(appointFind.getStatus());
			appoint.setTimeStart(appointFind.getTimeStart());
			appoint.setTimeEnd(appointFind.getTimeEnd());
			appoint.setDate(ConvertDateUtils.formatDateToString(appointFind.getDate(), ConvertDateUtils.DD_MM_YYYY));
			appoint.setCreatedBy(appointFind.getCreatedBy());
			newList.add(appoint);
		}
		return newList;
	}
	
	public void saveAppointment(AppointmentReq form) {
		logger.info("Appointment");
		Appointment appoint = null;
		if (StringUtils.isNotEmpty(form.getAppointmentId())) {		
			appoint = appointmentRepository.findById(Long.valueOf(form.getAppointmentId())).get();			
			appoint.setTitle(form.getTitle());
			appoint.setDescription(form.getDescription());		
			appoint.setStatus(form.getStatus());
			appoint.setTimeStart(form.getTimeStart());
			appoint.setTimeEnd(form.getTimeEnd());
			appoint.setDate(new Date());
		} else {
			appoint = new Appointment();
			appoint.setTitle(form.getTitle());
			appoint.setDescription(form.getDescription());		
			appoint.setStatus(form.getStatus());
			appoint.setTimeStart(form.getTimeStart());
			appoint.setTimeEnd(form.getTimeEnd());
			appoint.setDate(new Date());
		}
		
		appointmentRepository.save(appoint);
		
		AppointmentInvite userInvite = null;
		for (String userName : form.getListUser()) {
			userInvite = new AppointmentInvite();
			userInvite.setAppointmentId(appoint.getAppointmentId());
			userInvite.setUserIdInvite(userName);
			appointmentInviteReposity.save(userInvite);
		}
		
	}
	
	
	public AppointmentRes findById(AppointmentReq form) {
		logger.info("findById");
		Appointment appointment = appointmentRepository.findById(Long.valueOf(form.getAppointmentId())).get();		
		AppointmentRes newappointmentRes = new AppointmentRes();
		newappointmentRes.setAppointmentId(appointment.getAppointmentId());
		newappointmentRes.setTitle(appointment.getTitle());
		newappointmentRes.setDescription(appointment.getDescription());		
		newappointmentRes.setStatus(appointment.getStatus());
		newappointmentRes.setTimeStart(appointment.getTimeStart());
		newappointmentRes.setTimeEnd(appointment.getTimeEnd());
		newappointmentRes.setCreatedBy(appointment.getCreatedBy());
		newappointmentRes.setDate(ConvertDateUtils.formatDateToString(appointment.getDate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_EN));
		return newappointmentRes;
	}
	
	public Appointment editAppointment(AppointmentReq request) {
		Appointment appointment = null;
		appointment = new Appointment();
		// set data
		appointment = appointmentRepository.findById(Long.valueOf(request.getAppointmentId())).get();
		appointment.setTitle(request.getTitle());
		appointment.setDescription(request.getDescription());		
		appointment.setStatus(request.getStatus());
		appointment.setTimeStart(request.getTimeStart());
		appointment.setTimeEnd(request.getTimeEnd());
		appointment.setDate(new Date());
		appointment.setUpdatedBy("Phattartapong krintavee");
		appointment.setUpdatedDate(new Date());
		// save data
		return appointment;
//		appointmentRepository.save(appointment);
		
	}
	
	
}
