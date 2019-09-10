package baiwa.module.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baiwa.module.admin.dao.jpa.FwDepartRepository;
import baiwa.module.admin.dao.jpa.FwOrgRepository;
import baiwa.module.admin.model.FwDepartment;
import baiwa.module.admin.model.FwOrg;
import baiwa.module.admin.vo.request.FwDepartReq;
import baiwa.module.admin.vo.request.FwOrgReq;
import baiwa.module.admin.vo.response.FwDepartRes;
import baiwa.module.admin.vo.response.FwOrgRes;
import baiwa.util.ConvertDateUtils;

@Service
public class FwOrgService {
	
	private static final Logger logger = LoggerFactory.getLogger(FwOrgService.class);
	
	@Autowired
	private FwOrgRepository fwOrgRepository;
	
	@Autowired
	private FwDepartRepository fwDepartRepository;

	public List<FwOrgRes> getOrgList() {
		logger.info("getOrgList");
		List<FwOrg> listFind = fwOrgRepository.findAll();
		List<FwOrgRes> newList = new ArrayList<>();
		FwOrgRes org = null;
		for (FwOrg orgFind : listFind) {
			org = new FwOrgRes();
			org.setOrgId(orgFind.getOrgId());
			org.setOrgCode(orgFind.getOrgCode());
			org.setOrgDescription(orgFind.getOrgDescription());
			org.setCreateDate(ConvertDateUtils.formatDateToString(orgFind.getCreatedDate(), ConvertDateUtils.DD_MM_YYYY));
			newList.add(org);
		}
		return newList;
	}
	
	public FwOrgRes findById(FwOrgReq form) {
		logger.info("findById");
		FwOrg oldOrg = fwOrgRepository.findById(Long.valueOf(form.getOrgId())).get();
		FwOrgRes newOrg = new FwOrgRes();
		FwDepartRes dpt = null;
		List<FwDepartRes> dptList = new ArrayList<>();
		newOrg.setOrgId(oldOrg.getOrgId());
		newOrg.setOrgCode(oldOrg.getOrgCode());
		newOrg.setOrgDescription(oldOrg.getOrgDescription());
		newOrg.setCreateDate(ConvertDateUtils.formatDateToString(oldOrg.getCreatedDate(), ConvertDateUtils.DD_MM_YYYY));
		// set detail
		List<FwDepartment> departList = fwDepartRepository.findByOrgCode(oldOrg.getOrgCode());
		for (FwDepartment dp : departList) {
			dpt = new FwDepartRes();
			dpt.setDepartId(dp.getDepartId());
			dpt.setDepartCode(dp.getDepartCode());
			dpt.setDepartDesc(dp.getDepartDesc());
			dptList.add(dpt);
			newOrg.setDepartDetail(dptList);
		}
		return newOrg;
	}
	
	private Boolean checkList(String orgCode, String departId) {
		boolean isTrue = false;
		List<FwDepartment> departAll = fwDepartRepository.findByOrgCodeY(orgCode);
		for (FwDepartment dp : departAll) {
			if (departId.equals(String.valueOf(dp.getDepartId()))) {
				isTrue = true;
				break;
			}
		}
		return isTrue;
	}
	
	@Transactional
	public void saveOrg(FwOrgReq form) {
		logger.info("saveOrg");
		FwOrg org = null;
		FwDepartment depart = null;
		List<FwDepartment> departList = new ArrayList<>();
		List<FwDepartment> departAll = null;
		if (StringUtils.isNotEmpty(form.getOrgId())) {
			org = fwOrgRepository.findById(Long.valueOf(form.getOrgId())).get();
			org.setOrgCode(form.getOrgCode());
			org.setOrgDescription(form.getOrgDescription());
			org.setUpdatedBy("Tester");
			org.setUpdatedDate(new Date());
			departAll = fwDepartRepository.findAll();
			for (FwDepartment dpAll : departAll) {
				dpAll.setIsDelete("Y");
			}
			fwDepartRepository.saveAll(departAll);
			for (FwDepartReq dpDtl : form.getDepartDetail()) {
				if (checkList(form.getOrgCode(), dpDtl.getDepartId())) {
					depart = fwDepartRepository.findById(Long.valueOf(dpDtl.getDepartId())).get();
					depart.setOrgCode(form.getOrgCode());
					depart.setDepartCode(dpDtl.getDepartCode());
					depart.setDepartDesc(dpDtl.getDepartDesc());
					depart.setCreatedBy("Tester");
					depart.setCreatedDate(new Date());
					depart.setIsDelete("N");
				} else {
					depart = new FwDepartment();
					depart.setOrgCode(form.getOrgCode());
					depart.setDepartCode(dpDtl.getDepartCode());
					depart.setDepartDesc(dpDtl.getDepartDesc());
					depart.setCreatedBy("Tester");
					depart.setCreatedDate(new Date());
				}
				departList.add(depart);
			}
			
		} else {
			org = new FwOrg();
			org.setOrgCode(form.getOrgCode());
			org.setOrgDescription(form.getOrgDescription());
			org.setCreatedBy("Tester");
			org.setCreatedDate(new Date());
			for (FwDepartReq dp : form.getDepartDetail()) {
				depart = new FwDepartment();
				depart.setOrgCode(form.getOrgCode());
				depart.setDepartCode(dp.getDepartCode());
				depart.setDepartDesc(dp.getDepartDesc());
				depart.setCreatedBy("Tester");
				depart.setCreatedDate(new Date());
				departList.add(depart);
			}
		}
		
		fwOrgRepository.save(org);
		fwDepartRepository.saveAll(departList);
	}
	
	public void deleteOrg(FwOrgReq form) {
		logger.info("deleteOrg");
		FwOrg org = fwOrgRepository.findById(Long.valueOf(form.getOrgId())).get();
		List<FwDepartment> departList = fwDepartRepository.findByOrgCode(form.getOrgCode());
		
		org.setIsDelete("Y");
		
		for (FwDepartment dp : departList) {
			dp.setIsDelete("Y");
		}
		
		fwOrgRepository.save(org);
		fwDepartRepository.saveAll(departList);
		
	}
}
