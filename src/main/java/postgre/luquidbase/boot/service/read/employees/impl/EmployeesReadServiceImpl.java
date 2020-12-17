package postgre.luquidbase.boot.service.read.employees.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postgre.luquidbase.boot.dao.domain.employee.Employee;
import postgre.luquidbase.boot.dao.repository.EmployeesRepository;
import postgre.luquidbase.boot.service.dto.employee.EmployeeDto;
import postgre.luquidbase.boot.service.mapper.employyes.EmployeesMapper;
import postgre.luquidbase.boot.service.read.employees.EmployeesReadService;

import javax.transaction.Transactional;

@Service
public class EmployeesReadServiceImpl implements EmployeesReadService {

    private EmployeesRepository repository;

    private EmployeesMapper mapper;

    @Autowired
    public EmployeesReadServiceImpl(EmployeesRepository repository,
                                    EmployeesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public  Iterable<EmployeeDto> getAllEmployees() {

        Iterable<Employee> repositoryAll = repository.findAll();

        return toListEmployeesDto(repositoryAll);
    }


    public  Iterable<EmployeeDto> toListEmployeesDto(Iterable<Employee> list){
        return mapper.toListDto(list);
    }
}
