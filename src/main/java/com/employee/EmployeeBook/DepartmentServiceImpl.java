package com.employee.EmployeeBook;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DepartmentServiceImpl extends DepartmentService{
    private final EmployeeServiceImpl employeeService;
    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    double maxSalary = Double.MIN_VALUE;
    employeeService.getEmployee()


Comparator.comparingInt(employee -> employee.getSalary())
    @Override
    public Employee findEmployeeWithMaxSalary(int department) {

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() > maxSalary) {
                    employeeWithMaxSalary = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return employeeWithMaxSalary;
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        Employee employeeWithMinSalary = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() < minSalary) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
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



    @Override
    public double calculateSumOfSalaryForMonth() {

    }

    @Override
    public double salariesByEmployee() {
        double sum = 0;
        for (employee:
             employees) {
            sum += employee.getValues();
        }
    }

        @Override
        public Employee findEmployeeWithMinSalary() {

        }
        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }
    @Override
    public Employee findEmployeeWithMaxSalary() {
        if(employees.length == 0)
            return null;
        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }
    @Override
    public double calculateAverageSalary() {
        calculateSumOfSalaryForMonth() / size();
    }

    @Override
    public void printFullNamesOfEmployee() {
        forEach (e : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    @Override
    public void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent);
            }
        }
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() > maxSalary) {
                    employeeWithMaxSalary = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return employeeWithMaxSalary;
    }

    @Override
    public double calculateSumOfSalaryForMonth(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    @Override
    public int departmentCount(int dep){
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                count++;
            }
        }
        return count;
    }
    @Override
    public double calculateAverageSalary(int dep) {
        return calculateSumOfSalaryForMonth(dep) / departmentCount(dep);
    }

    @Override
    public void indexTheSalary(int dep, double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == dep) {
                    employee.setSalary(employee.getSalary() + (employee.getSalary() * percent));
                }
            }
        }
    }

    @Override
    public void dataOfEmployee(int dep) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == dep) {
                    System.out.println("id:" + employee.getId() + ", fullName: " + employee.getFullName()
                            + ", salary: " + employee.getSalary());
                }
            }
        }
    }
    @Override
    public void getEmployeeForId(int id) {
        if (employees[id] != null) {
            System.out.println(employees[id].toString());
        }
    }
    @Override
    public void compareSalaryLessArgs(double compareArgs) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < compareArgs) {
                    System.out.println("id:" + employee.getId() + ", fullName: " + employee.getFullName()
                            + ", salary: " + employee.getSalary());
                }
            }
        }
    }

    @Override
    public void compareSalaryMoreArgs(double compareArgs) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > compareArgs) {
                    System.out.println("id:" + employee.getId() + ", fullName: " + employee.getFullName()
                            + ", salary: " + employee.getSalary());
                }
            }
        }
    }
}
