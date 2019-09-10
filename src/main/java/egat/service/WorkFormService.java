package egat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import egat.model.WorkStatus;


@Service
public class WorkFormService {

	public List<WorkStatus> getWorkStatusList() {
		List<WorkStatus> newList = new ArrayList<>();
		WorkStatus workStatus = new WorkStatus();
		workStatus.setName("งานทั้งหมด");
		workStatus.setTotal("256");
		newList.add(workStatus);

		workStatus = new WorkStatus();
		workStatus.setName("งานที่กำลังดำเนินการ");
		workStatus.setTotal("125");
		newList.add(workStatus);
		
		workStatus = new WorkStatus();
		workStatus.setName("งานที่กำลังดำเนินการ");
		workStatus.setTotal("125");
		newList.add(workStatus);
		
		workStatus = new WorkStatus();
		workStatus.setName("งานที่สำเร็จก่อนกำหนด");
		workStatus.setTotal("100");
		newList.add(workStatus);
		
		workStatus = new WorkStatus();
		workStatus.setName("งานที่สำเร็จตามกำหนด");
		workStatus.setTotal("50");
		newList.add(workStatus);
		return newList;
	}
}
