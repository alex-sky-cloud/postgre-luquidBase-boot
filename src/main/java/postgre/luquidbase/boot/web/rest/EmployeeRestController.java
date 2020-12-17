package postgre.luquidbase.boot.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postgre.luquidbase.boot.service.dto.employee.EmployeeDto;
import postgre.luquidbase.boot.service.read.employees.EmployeesReadService;
import postgre.luquidbase.boot.service.save.employee.EmployeeSaveService;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {

    private final EmployeesReadService employeesReadService;

    private final EmployeeSaveService employeeSaveService;

    @Autowired
    public EmployeeRestController(EmployeesReadService employeesReadService,
                                  EmployeeSaveService employeeSaveService) {
        this.employeesReadService = employeesReadService;
        this.employeeSaveService = employeeSaveService;
    }

    @PostMapping(path = "/addEmployee")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        EmployeeDto employeeDto = EmployeeDto
                .newBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        employeeSaveService.setEmployee(employeeDto);
        return "Saved Employee";
    }

    @GetMapping(path = "/getAllEmployees")
    public  Iterable getAllEmployees() {
        return employeesReadService.getAllEmployees();
    }
}
