package baiwa.module.admin.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baiwa.bean.ResponseData;
import baiwa.module.admin.dao.MasterDataCacheDao;
import baiwa.module.admin.model.MasterDataCacheItem;
import baiwa.module.admin.model.MasterReq;
import baiwa.util.ApplicationCache;

@Service
public class MasterDataCacheService {
	
	@Autowired
	private MasterDataCacheDao masterDataCacheDao;
	
	public HashMap<String, List<MasterDataCacheItem>> getListMaster(){
		List<String> header = masterDataCacheDao.getHeaderKey();
		List<MasterDataCacheItem> itemDetail = null;
		HashMap<String, List<MasterDataCacheItem>> allItem =  new HashMap<String, List<MasterDataCacheItem>>();
		
		for (String item : header) {
			itemDetail = masterDataCacheDao.getDetailItem(item);
			if(StringUtils.isNotBlank(item)) {
				allItem.put(item, itemDetail);
			}
		}
		return allItem;
	}
	
	
	public ResponseData<List<MasterDataCacheItem>> getDrondown( MasterReq req ){
		HashMap<String, List<MasterDataCacheItem>> listCache = ApplicationCache.getMaster();
		
		ResponseData<List<MasterDataCacheItem>> response = new  ResponseData<List<MasterDataCacheItem>>();
		response.setData(listCache.get(req.getKeyword()));
		return response;
	}
}
