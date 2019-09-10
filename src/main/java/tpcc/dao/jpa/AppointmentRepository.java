package tpcc.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tpcc.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	@Query("select e from #{#entityName} e where e.isDeleted = 'N'")
	public List<Appointment> findAll();
}
