package postgre.luquidbase.boot.dao.repository;

import org.springframework.data.repository.CrudRepository;
import postgre.luquidbase.boot.dao.domain.employee.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {
}
