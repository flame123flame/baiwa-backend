package tpcc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import baiwa.util.ConvertDateUtils;
import tpcc.dao.jpa.NewsInviteReposity;
import tpcc.dao.jpa.NewsRepository;
import tpcc.model.Appointment;
import tpcc.model.News;
import tpcc.vo.request.AppointmentReq;
import tpcc.vo.request.NewsReq;
import tpcc.vo.response.AppointmentRes;
import tpcc.vo.response.NewsRes;

@Service
public class NewsService {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);
	
	@Value("${file.img.path}")
	private String pathImg;

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsInviteReposity newsInviteReposity;

	public List<NewsRes> getNewsList( ) {
		logger.info("getNewsList");
		List<News> listFind = newsRepository.findAll();
		List<NewsRes> newList = new ArrayList<>();
		NewsRes newsres = null;
		for (News news : listFind) {
			newsres = new NewsRes();
			newsres.setNewsId(news.getNewsId());
			newsres.setTitle(news.getTitle());
			newsres.setDescription(news.getDescription());	
			newsres.setStartDate(ConvertDateUtils.formatDateToString(news.getStartdate(), ConvertDateUtils.DD_MM_YYYY));
			newsres.setEndDate(ConvertDateUtils.formatDateToString(news.getEnddate(), ConvertDateUtils.DD_MM_YYYY));
			newList.add(newsres);
		}
		return newList;
	}
	
	
	public void saveNews(NewsReq form) {
		logger.info("News");
		News news = null;
		if (StringUtils.isNotEmpty(form.getNewsId())) {		
			news = newsRepository.findById(Long.valueOf(form.getNewsId())).get();			
			news.setTitle(form.getTitle());
			news.setDescription(form.getDescription());		
			news.setImage(form.getImage());
			news.setStartdate(new Date());
			news.setEnddate(new Date());
		} else {
			news = new News();
			news.setTitle(form.getTitle());
			news.setDescription(form.getDescription());		
			news.setImage("");
			news.setStartdate(new Date());
			news.setEnddate(new Date());
		}
		
		newsRepository.save(news);
		
	}
	
//	public NewsRes findById(NewsReq form) {
//		logger.info("findById");
//		News news = newsRepository.findById(Long.valueOf(form.getNewsId())).get();		
//		NewsRes newsRes = new NewsRes();
//		newsRes.setNewsId(news.getNewsId());
//		newsRes.setTitle(news.getTitle());
//		newsRes.setDescription(news.getDescription());		
//		newsRes.setStartDate(ConvertDateUtils.formatDateToString(news.getStartdate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));
//		newsRes.setEndDate(ConvertDateUtils.formatDateToString(news.getEnddate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));	
//		newsRes.setCreatedBy(news.getCreatedBy());
//		newsRes.setCreatedDate(ConvertDateUtils.formatDateToString(news.getCreatedDate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));
//		return newsRes;
//	}
//	
	
	public NewsRes findById(NewsReq form) {
		logger.info("findById");
		News news = newsRepository.findById(Long.valueOf(form.getNewsId())).get();		
		NewsRes newsRes = new NewsRes();		
		newsRes.setNewsId(news.getNewsId());
		newsRes.setTitle(news.getTitle());
		newsRes.setDescription(news.getDescription());		
		newsRes.setStartDate(ConvertDateUtils.formatDateToString(news.getStartdate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));
		newsRes.setEndDate(ConvertDateUtils.formatDateToString(news.getEnddate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));	
		newsRes.setCreatedBy(news.getCreatedBy());
		newsRes.setCreatedDate(ConvertDateUtils.formatDateToString(news.getCreatedDate(), ConvertDateUtils.DD_MM_YYYY,ConvertDateUtils.LOCAL_TH));
		return newsRes;
	}
	public News editNews(NewsReq request) {
		News news = null;
		news = new News();
		// set data
		news = newsRepository.findById(Long.valueOf(request.getNewsId())).get();
		news.setTitle(request.getTitle());
		news.setDescription(request.getDescription());
		news.setStartdate(new Date());
		news.setEnddate(new Date());
		news.setUpdatedBy("Phattartapong krintavee");
		news.setUpdatedDate(new Date());
		return news;
//		appointmentRepository.save(appointment);
		
	}
	
}
