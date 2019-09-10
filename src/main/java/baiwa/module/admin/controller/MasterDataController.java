package baiwa.module.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import baiwa.bean.ResponseData;
import baiwa.module.admin.model.MasterDataCacheItem;
import baiwa.module.admin.model.MasterReq;
import baiwa.module.admin.service.MasterDataCacheService;

@Controller
@RequestMapping("api/master")
public class MasterDataController {
	
	@Autowired
	MasterDataCacheService masterDateService;
	
	@PostMapping("/list")
	@ResponseBody
	public ResponseData<List<MasterDataCacheItem>>  list(@RequestBody MasterReq req ) {
		return masterDateService.getDrondown(req);
	}

}
