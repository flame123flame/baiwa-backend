package baiwa.module.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baiwa.module.admin.dao.SystemConstantDao;
import baiwa.module.admin.dao.jpa.SystemConstantRepository;
import baiwa.module.admin.model.SystemConstant;
import baiwa.module.admin.vo.request.SysConstantReq;

@Service
public class SysConstantService {
	
	@Autowired
	private SystemConstantRepository systemConstantRepository;
	
	@Autowired
	private SystemConstantDao systemConstantDao; 
	
	public List<SystemConstant> list(SysConstantReq form) {
		List<SystemConstant> constants = new ArrayList<SystemConstant>();
		constants = systemConstantDao.list(form);
		return constants;
	}
	
	public SystemConstant listdata(SysConstantReq form) {
		SystemConstant constants = new SystemConstant();
		constants = systemConstantRepository.findById(form.getConstantId()).get();
		return constants;
	}
	
	public void saveConstant(SysConstantReq request) {
		SystemConstant systemConstant = null;
		systemConstant = new SystemConstant();
		// set data
		systemConstant.setConstantKey(request.getConstantKey());
		systemConstant.setConstantValue(request.getConstantValue());
		systemConstant.setCreatedBy("Phattartapong krintavee");
		systemConstant.setCreatedDate(new Date());
		// save data
		systemConstantRepository.save(systemConstant);
	}
	
	public void editConstant(SysConstantReq request) {
		SystemConstant systemConstant = null;
		systemConstant = new SystemConstant();
		// set data
		systemConstant = systemConstantRepository.findById(request.getConstantId()).get();
		systemConstant.setConstantKey(request.getConstantKey());
		systemConstant.setConstantValue(request.getConstantValue());
		systemConstant.setUpdatedBy("Phattartapong krintavee");
		systemConstant.setUpdatedDate(new Date());
		// save data
		systemConstantRepository.save(systemConstant);
	}

	public SystemConstant getConstantByKey(String key) {
		return systemConstantRepository.findByConstantKey(key);
	}

}
