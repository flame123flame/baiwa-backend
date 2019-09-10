package baiwa.module.admin.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import baiwa.module.admin.model.SystemConstant;

@Repository
public interface SystemConstantRepository extends CrudRepository<SystemConstant, Long> {

	public SystemConstant findByConstantKey(String key);

}
