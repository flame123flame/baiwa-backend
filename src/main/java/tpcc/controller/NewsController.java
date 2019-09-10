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
import tpcc.model.News;
import tpcc.service.NewsService;
import tpcc.vo.request.NewsReq;
import tpcc.vo.response.NewsRes;

@Controller
@RequestMapping("api/news")
public class NewsController {

	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	
	@Autowired
	private NewsService newsService;
	
	
	@PostMapping("/get_all")
	@ResponseBody
	public ResponseData<List<NewsRes>> listdata() {
		ResponseData<List<NewsRes>> responseData = new ResponseData<List<NewsRes>>();
		try {
			responseData.setData(newsService.getNewsList());
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
	public ResponseData<NewsRes> findById(@RequestBody NewsReq form) {
		ResponseData<NewsRes> responseData = new ResponseData<NewsRes>();
		try {
			responseData.setData(newsService.findById(form));
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
	public ResponseData<?> saveNews(@RequestBody NewsReq form) {
		ResponseData<?> responseData = new ResponseData<>();
		try {
			newsService.saveNews(form);
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
	public ResponseData<News> EditAppointment(@RequestBody NewsReq form) {
		ResponseData<News> responseData = new ResponseData<News>();
		try {
			responseData.setData(newsService.editNews(form));			
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
