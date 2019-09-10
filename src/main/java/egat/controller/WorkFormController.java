package egat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egat.model.WorkStatus;
import egat.service.WorkFormService;

@Controller
@RequestMapping("api/egat")
public class WorkFormController {

	
	@Autowired
	private WorkFormService workFormService;
	
	
	@PostMapping("/getWorkStatusList")
	@ResponseBody
	public List<WorkStatus>  WorkStatusList() {

		return workFormService.getWorkStatusList();
	}
	
}
