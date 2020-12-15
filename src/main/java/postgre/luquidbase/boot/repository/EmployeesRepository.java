package postgre.luquidbase.boot.repository;

import org.springframework.data.repository.CrudRepository;
import postgre.luquidbase.boot.domain.employee.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {
}
