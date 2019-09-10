package baiwa.module.admin.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import baiwa.module.admin.model.FwDepartment;

public interface FwDepartRepository extends CrudRepository<FwDepartment, Long> {
	
	@Query("select e from #{#entityName} e where e.isDelete = 'N'")
	public List<FwDepartment> findAll();
	
	@Query("select e from #{#entityName} e where e.isDelete = 'N' and e.orgCode = :orgCode")
	public List<FwDepartment> findByOrgCode(@Param("orgCode") String orgCode);
	
	@Query("select e from #{#entityName} e where e.isDelete = 'Y' and e.orgCode = :orgCode")
	public List<FwDepartment> findByOrgCodeY(@Param("orgCode") String orgCode);
}
