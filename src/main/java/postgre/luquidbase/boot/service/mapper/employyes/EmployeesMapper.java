package postgre.luquidbase.boot.service.mapper.employyes;

import org.mapstruct.Mapper;
import postgre.luquidbase.boot.dao.domain.employee.Employee;
import postgre.luquidbase.boot.service.dto.employee.EmployeeDto;
import postgre.luquidbase.boot.service.mapper.CommonMapper;

@Mapper(componentModel = "spring")
public interface EmployeesMapper extends CommonMapper <EmployeeDto,Employee> {
}
