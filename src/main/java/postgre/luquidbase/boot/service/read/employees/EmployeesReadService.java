package postgre.luquidbase.boot.service.read.employees;

import postgre.luquidbase.boot.service.dto.employee.EmployeeDto;

public interface EmployeesReadService {

    Iterable <EmployeeDto> getAllEmployees();
}
