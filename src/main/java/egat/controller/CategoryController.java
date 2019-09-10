package egat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egat.model.Category;
import egat.service.CategoryService;
import egat.vo.request.GetDataChangeIpReq;
import egat.vo.response.GetDataChangeIpRes;

@Controller
@RequestMapping("api/egat")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/getCatList")
	@ResponseBody
	public List<Category> CategoryList() {

		return categoryService.getCatList();
	}
	
	@PostMapping("/getWorkFormList")
	@ResponseBody
	public  List<Category> getWorkFormList() {

		return categoryService.getWorkFormList();

	}
	
	@PostMapping("/getWorkFormListById/{id}")
	@ResponseBody
	public  Category getWorkFormListById(@PathVariable("id") int id) {

		return categoryService.getWorkFormListById(id);

	}
	
	@PostMapping("/getDataChangeIp")
	@ResponseBody
	public  GetDataChangeIpRes getDataChangeIp(@RequestBody GetDataChangeIpReq form) {

		return categoryService.getDataChangeIp(form);

	}
}
