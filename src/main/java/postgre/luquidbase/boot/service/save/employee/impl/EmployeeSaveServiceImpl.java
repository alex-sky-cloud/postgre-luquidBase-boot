package postgre.luquidbase.boot.service.save.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postgre.luquidbase.boot.dao.domain.employee.Employee;
import postgre.luquidbase.boot.dao.repository.EmployeesRepository;
import postgre.luquidbase.boot.service.dto.employee.EmployeeDto;
import postgre.luquidbase.boot.service.mapper.employyes.EmployeesMapper;
import postgre.luquidbase.boot.service.save.employee.EmployeeSaveService;

import javax.transaction.Transactional;

@Service
public class EmployeeSaveServiceImpl implements EmployeeSaveService {

    private EmployeesRepository repository;

    private EmployeesMapper mapper;

    @Autowired
    public EmployeeSaveServiceImpl(EmployeesRepository repository, EmployeesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void setEmployee(EmployeeDto dto) {
        Employee employee = toEntity(dto);

        repository.save(employee);
    }

    private Employee toEntity(EmployeeDto dto){
        return mapper.toEntity(dto);
    }
}
