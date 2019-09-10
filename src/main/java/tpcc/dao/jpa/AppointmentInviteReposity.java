package tpcc.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpcc.model.AppointmentInvite;

@Repository
public interface AppointmentInviteReposity extends CrudRepository<AppointmentInvite, Long> {

}
