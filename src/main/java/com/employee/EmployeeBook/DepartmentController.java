package com.employee.EmployeeBook;
import com.employee.EmployeeBook.exception.ArrayIsFull;
import com.employee.EmployeeBook.exception.EmployeeAlreadyAdded;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
        private final DepartmentServiceImpl departmentService;
        public DepartmentController(DepartmentServiceImpl departmentService) {   // инжектим сервис в контроллер
            this.departmentService = departmentService;
        }


        @GetMapping(path = "/max-salary")
        public Employee findEmployeeWithMaxSalary(@RequestParam ("department") int department) {
            return departmentService.findEmployeeWithMaxSalary(department);
        }

        @GetMapping(path = "/min-salary")
        public Employee findEmployeeWithMinSalary(@RequestParam ("department") int department) {
            return departmentService.findEmployeeWithMinSalary(department);
        }

        @GetMapping(path = "/all)




    }
 /* Заменить реализацию через циклы на Stream API. Написать новый контроллер и сервис, которые будут:
        Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
        /departments/max-salary?departmentId=5

        Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
        /departments/min-salary?departmentId=5

        Возвращать всех сотрудников по отделу.
        /departments/all?departmentId=5

        Возвращать всех сотрудников с разделением по отделам.
        /departments/all


        Для того чтобы получить список сотрудников, надо в новый сервис заинжектить старый сервис и запросить список всех сотрудников, затем этот список пропустить через Stream API.
        Для поиска минимальной или максимальной зарплаты нужно после фильтрации использовать методы min и max, передав в качестве компаратора строку кода, представленную ниже.
        Comparator.comparingInt(employee -> employee.getSalary())

    */