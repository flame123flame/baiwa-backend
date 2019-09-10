package egat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import egat.constant.AlignmentText;
import egat.constant.InputType;
import egat.model.Category;
import egat.model.WorkForm;
import egat.vo.request.GetDataChangeIpReq;
import egat.vo.response.FormChangeDtl2Res;
import egat.vo.response.FormChangeDtlRes;
import egat.vo.response.GetDataChangeIpRes;

@Service
public class CategoryService {

	public List<Category> getCatList() {
		List<Category> newList = new ArrayList<>();
		Category ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(1));
		ctg.setName("Network Communnicaton Internet Network security");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(2));
		ctg.setName("Cloud");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(3));
		ctg.setName("E-mail");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(4));
		ctg.setName("EGAT Account (SAP,Non-SAP)");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(5));
		ctg.setName("Database as a Service");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(6));
		ctg.setName("WIFI Wireless");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(7));
		ctg.setName("Big Data");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(8));
		ctg.setName("Data Center");
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(9));
		ctg.setName("Phone");
		newList.add(ctg);

		return newList;

	}

	public List<Category> getWorkFormList() {
		List<Category> newList = new ArrayList<>();

		Category ctg = new Category();

		List<WorkForm> workList = getWorkFormListd();

		ctg.setCattegoryId(Long.valueOf(1));
		ctg.setName("Network Communnicaton Internet Network security");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(2));
		ctg.setName("Cloud");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(3));
		ctg.setName("E-mail");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(4));
		ctg.setName("EGAT Account (SAP,Non-SAP)");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(5));
		ctg.setName("WIFI Wireless");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(6));
		ctg.setName("Big Data");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(7));
		ctg.setName("Data Center");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		ctg = new Category();
		ctg.setCattegoryId(Long.valueOf(8));
		ctg.setName("Phone");
		ctg.setWorkFormList(workList);
		newList.add(ctg);

		return newList;

	}

	public Category getWorkFormListById(int id) {
		Category ctg = new Category();
		List<WorkForm> workList = getWorkFormListd();
		ctg.setCattegoryId(Long.valueOf(1));
		ctg.setName("Menu " + String.valueOf(id));
		ctg.setWorkFormList(workList);
		return ctg;
	}

	public List<WorkForm> getWorkFormListd() {
		List<WorkForm> workList = new ArrayList<>();
		WorkForm work = new WorkForm();
		work.setName("บริการงานสำรวจ ออกแบบ ระบบ");
		work.setCattegoryId(Long.valueOf(1));
		work.setWorkFormId(Long.valueOf(1));
		workList.add(work);

		work = new WorkForm();
		work.setCattegoryId(Long.valueOf(1));
		work.setWorkFormId(Long.valueOf(2));
		work.setName("ขอใช้บริการติดตั้งปรับปรุงสายสัญญาณ");
		workList.add(work);

		work = new WorkForm();
		work.setCattegoryId(Long.valueOf(1));
		work.setWorkFormId(Long.valueOf(3));
		work.setName("ขอเชื่อมต่ออุปกรณ์เข้าเครือข่าย");
		workList.add(work);

		work = new WorkForm();
		work.setCattegoryId(Long.valueOf(1));
		work.setWorkFormId(Long.valueOf(4));
		work.setName("ขอใช้บริการติดตั้งปรับปรุงสายสัญญาณ");
		workList.add(work);

		work = new WorkForm();
		work.setCattegoryId(Long.valueOf(1));
		work.setWorkFormId(Long.valueOf(5));
		work.setName("ขอใช้บริการอินเทอร์เน็ตช่องทางการพิเศษ");
		workList.add(work);
		return workList;
	}

	public GetDataChangeIpRes getDataChangeIp(GetDataChangeIpReq formReq) {
		GetDataChangeIpRes dataRes = new GetDataChangeIpRes();
		dataRes.setCattegoryId(formReq.getCattegoryId());
		dataRes.setUserId(formReq.getUserId());
		dataRes.setWorkFormId(formReq.getWorkFormId());
		List<FormChangeDtlRes> dtlList = new ArrayList<FormChangeDtlRes>();
		FormChangeDtlRes dtlSet = null;
		List<FormChangeDtl2Res> dtl2ListSet = null;
		FormChangeDtl2Res dtl2Set = null;
		if (1 == formReq.getWorkFormId()) {
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT_FIELDS);
			dtlSet.setHintText("fields1 hintText");
			dtlSet.setTextLabel("fields1");
			dtlSet.setOrder(2l);
			dtlList.add(dtlSet);
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT_FIELDS);
			dtlSet.setHintText("fields2 hintText");
			dtlSet.setTextLabel("fields2");
			dtlSet.setOrder(3l);
			dtlSet.setValueStr("initail data");
			dtlList.add(dtlSet);
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT_FIELDS);
			dtlSet.setHintText("fields3 hintText");
			dtlSet.setTextLabel("fields3");
			dtlSet.setFieldEnabled(false);
			dtlSet.setOrder(4l);
			dtlList.add(dtlSet);
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT_FIELDS);
			dtlSet.setHintText("fields4 hintText");
			dtlSet.setTextLabel("fields4 require");
			dtlSet.setRequire(true);;
			dtlSet.setOrder(5l);
			dtlList.add(dtlSet);
			
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.RADIO);
			dtlSet.setTextLabel("radio2");
			dtlSet.setGroupSelect("radio1Value");
			dtlSet.setOrder(6l);
			dtl2ListSet = new ArrayList<FormChangeDtl2Res>();
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("radio1");
			dtl2Set.setValue("radio1Value");
			dtl2ListSet.add(dtl2Set);
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("radio2");
			dtl2Set.setValue("radio2Value");
			dtl2ListSet.add(dtl2Set);
			dtlSet.setValueObj(dtl2ListSet);
			dtlList.add(dtlSet);
		} else if (2 == formReq.getWorkFormId()) {
			// Text
			// ColorText hex 8 bit
			// 2 bit (Most significant bit) => opacity
			// 6 bit (Least significant bit) => color
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT);
			dtlSet.setHintText("Text1FormAPI");
			dtlSet.setTextLabel("fields1");
			dtlSet.setOrder(0l);
			// if InputType is Text then Require 3 obj
			dtlSet.setAlignmentText(AlignmentText.CENTER);
			dtlSet.setColorText("0xff000000");
			// FontSize 20 18 16
			dtlSet.setFontSize(20d);
			dtlList.add(dtlSet);
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.TEXT);
			dtlSet.setHintText("Text1FormAPI");
			dtlSet.setTextLabel("fields1");
			dtlSet.setOrder(1l);
			// if InputType is Text then Require 3 obj
			dtlSet.setAlignmentText(AlignmentText.RIGHT);
			dtlSet.setColorText("0xffff0000");
			dtlSet.setFontSize(16d);
			dtlList.add(dtlSet);
			
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.CHECKBOX);
			dtlSet.setTextLabel("checkbox1");
			dtlSet.setOrder(0l);
			dtl2ListSet = new ArrayList<FormChangeDtl2Res>();
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("checkboxText1");
			dtl2Set.setValue("true");
			dtl2ListSet.add(dtl2Set);
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("checkboxText2");
			dtl2Set.setValue("true");
			dtl2ListSet.add(dtl2Set);
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("checkboxText3");
			dtl2Set.setValue("false");
			dtl2ListSet.add(dtl2Set);
			
			dtlSet.setValueObj(dtl2ListSet);
			dtlList.add(dtlSet);
			
			// 2
			dtlSet = new FormChangeDtlRes();
			dtlSet.setInputType(InputType.DROPDOWN);
			dtlSet.setTextLabel("dropdown2");
			dtlSet.setHintText("dropdown hintText");
			dtlSet.setOrder(1l);
			
			dtl2ListSet = new ArrayList<FormChangeDtl2Res>();
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("text1");
			dtl2Set.setValue("text1 Value");
			dtl2ListSet.add(dtl2Set);
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("text2");
			dtl2Set.setValue("text2 Value");
			dtl2ListSet.add(dtl2Set);
			
			dtl2Set = new FormChangeDtl2Res();
			dtl2Set.setText("text3");
			dtl2Set.setValue("text3 Value");
			dtl2ListSet.add(dtl2Set);
			
			dtlSet.setValueObj(dtl2ListSet);		
			dtlList.add(dtlSet);
			
			
		}
		dataRes.setDetail(dtlList);
		return dataRes;
	}

}
