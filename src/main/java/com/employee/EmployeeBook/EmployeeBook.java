public class EmployeeBook {
    private final Employee employees[];
    public EmployeeBook(int size){
        this.employees = new Employee[size];
    }

    public int size(){
        int size = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                size++;
            }
        }
        return size;
    }

    public void dataOfEmployee() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public double calculateSumOfSalaryForMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    public Employee findEmployeeWithMinSalary() {
        if(employees.length == 0)
            return null;
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

    public double calculateAverageSalary() {
        if(employees.length == 0)
            return 0.0;
        return calculateSumOfSalaryForMonth() / size();
    }


    public void printFullNamesOfEmployee() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }


    public void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent);
            }
        }
    }

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


    public double calculateSumOfSalaryForMonth(int department) {
        double sum = 0;
            for (Employee employee : employees) {
                    if (employee.getDepartment() == department) {
                        sum += employee.getSalary();
                    }
                }
            return sum;
        }

    public int departmentCount(int dep){
       int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                count++;
            }
        }
        return count;
    }

    public double calculateAverageSalary(int dep) {
        return calculateSumOfSalaryForMonth(dep) / departmentCount(dep);
    }


    public void indexTheSalary(int dep, double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == dep) {
                    employee.setSalary(employee.getSalary() + (employee.getSalary() * percent));
                }
            }
        }
    }


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

    public void getEmployeeForId(int id) {
        if (employees[id] != null) {
            System.out.println(employees[id].toString());
        }
    }

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

    public void delete(int index) {
       employees[index] = null;
                }


    public boolean add(Employee newEmployee) {
        boolean result = false;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void printMessage(String str){
        System.out.println(str);
    }

}

