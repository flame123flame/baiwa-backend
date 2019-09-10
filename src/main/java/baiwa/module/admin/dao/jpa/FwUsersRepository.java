package baiwa.module.admin.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import baiwa.module.admin.model.FwUsers;

@Repository
public interface FwUsersRepository extends CrudRepository<FwUsers, Long> {
	
	@Query(value = "select * from fw_users e where e.is_delete = 'N' " , nativeQuery = true)
	public List<FwUsers>  findAll();
}