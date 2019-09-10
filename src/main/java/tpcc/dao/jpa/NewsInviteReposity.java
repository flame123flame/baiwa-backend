package tpcc.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import tpcc.model.News;

public interface NewsInviteReposity extends CrudRepository<News, Long> {

}
