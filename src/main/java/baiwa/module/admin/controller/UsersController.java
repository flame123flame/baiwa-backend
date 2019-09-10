package baiwa.module.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import baiwa.bean.DataTableAjax;
import baiwa.bean.ResponseData;
import baiwa.module.admin.model.FwUserDetail;
import baiwa.module.admin.model.FwUsers;
import baiwa.module.admin.service.FwRoleService;
import baiwa.module.admin.service.FwUserRoleService;
import baiwa.module.admin.service.FwUserService;
import baiwa.module.admin.vo.request.FwUserRoleReq;
import baiwa.module.admin.vo.request.UsersReq;
import baiwa.module.admin.vo.response.FwRoleRes;
import baiwa.util.constant.ProjectConstant.RESPONSE_MESSAGE;
import baiwa.util.constant.ProjectConstant.RESPONSE_STATUS;

@Controller
@RequestMapping("api/users")
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private FwUserService fwUserService;

	@Autowired
	private FwRoleService fwRoleService;

	@Autowired
	private FwUserRoleService fwUserRoleService;

	@PostMapping("/list")
	@ResponseBody
	public List<String> list(@RequestBody UsersReq req) {
		return fwUserService.getAlluser(req);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/listAll")
	@ResponseBody
	public DataTableAjax<FwUsers> listAll() {
		DataTableAjax<FwUsers> response = new DataTableAjax<FwUsers>();
		List<FwUsers> fwUserList = new ArrayList<FwUsers>();
		try {
			fwUserList = fwUserService.listAll();
			response.setData(fwUserList);
		} catch (Exception e) {
			logger.error("UsersController : ", e);
		}
		return response;
	}

	@PostMapping("/getUser")
	@ResponseBody
	public ResponseData<FwUserDetail> listId(@RequestBody UsersReq request) {
		ResponseData<FwUserDetail> responseData = new ResponseData<FwUserDetail>();
		try {
			responseData.setData(fwUserService.getUser(request));
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("UsersController::find ", e);
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}

	@PostMapping("/save")
	@ResponseBody
	public ResponseData<String> saveUser(@RequestBody UsersReq request) {
		ResponseData<String> responseData = new ResponseData<String>();
		try {
			fwUserService.saveUser(request);
			responseData.setData("SUCCESS");
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}

	@PostMapping("/edit")
	@ResponseBody
	public ResponseData<String> editUser(@RequestBody UsersReq request) {
		ResponseData<String> responseData = new ResponseData<String>();
		try {
			fwUserService.editUser(request);
			responseData.setData("SUCCESS");
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}

	@PostMapping("/save_user_role")
	@ResponseBody
	public ResponseData<?> saveUserRole(@RequestBody FwUserRoleReq form) {
		ResponseData<?> responseData = new ResponseData<>();
		try {
			fwUserRoleService.saveUserRole(form);
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("UserRoleController::saveUserRole ", e);
			responseData.setMessage(RESPONSE_MESSAGE.SAVE.FAILED);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}

	@GetMapping("/get_all")
	@ResponseBody
	public ResponseData<List<FwRoleRes>> listdata() {
		ResponseData<List<FwRoleRes>> responseData = new ResponseData<List<FwRoleRes>>();
		try {
			responseData.setData(fwRoleService.getRoleList());
			responseData.setMessage(RESPONSE_MESSAGE.SUCCESS);
			responseData.setStatus(RESPONSE_STATUS.SUCCESS);
		} catch (Exception e) {
			logger.error("RoleController::listdata ", e);
			responseData.setMessage(RESPONSE_MESSAGE.ERROR500);
			responseData.setStatus(RESPONSE_STATUS.FAILED);
		}
		return responseData;
	}

}