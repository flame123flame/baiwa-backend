package tpcc.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpcc.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
	@Query("select e from #{#entityName} e where e.isDeleted = 'N'")
	public List<News> findAll();
}
