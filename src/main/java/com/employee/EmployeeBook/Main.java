public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook(10);
        book.add(EmployeeTest.generalManager);
        book.add(EmployeeTest.directorOfProduction);
        book.add(EmployeeTest.engineer);
        book.add(EmployeeTest.economist);
        book.add(EmployeeTest.secretary);
        book.add(EmployeeTest.worker);
        book.add(EmployeeTest.mainEngineer);
        book.add(EmployeeTest.estimator);
        book.add(EmployeeTest.salesSpecialist);
        book.add(EmployeeTest.accountant);

        book.printMessage(Message.ALLDATA);
        book.dataOfEmployee();
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.MINSALARY + book.findEmployeeWithMinSalary());
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.MAXSALARY + book.findEmployeeWithMaxSalary());
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.AVERAGESALARY + book.calculateAverageSalary());
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.SUMMONTH + book.calculateSumOfSalaryForMonth());
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.ALLFIO);
        book.printFullNamesOfEmployee();
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.INDEX);
        book.indexSalary(0.05);
        book.dataOfEmployee();
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.MINSALARYDEP + book.findEmployeeWithMinSalary(2));
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.MAXSALARYDEP + book.findEmployeeWithMaxSalary(2));
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.LIST);
        book.dataOfEmployee(2);
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.SALARYMORE);
        book.compareSalaryMoreArgs(150000.0);
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.SALARYLESS);
        book.compareSalaryLessArgs(150000.0);
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.INDEXDEP);
        book.indexTheSalary(2, 0.05);
        book.dataOfEmployee(2);
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.AVERAGEDEP + book.calculateAverageSalary(2));
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.SUMMONTHDEP + book.calculateSumOfSalaryForMonth(2));
        book.printMessage(Message.SEPARATOR);

        book.printMessage(Message.DELETE);
        book.delete(3);

        book.printMessage(Message.ADD);
        Employee welder = new Employee("Мурзинов Павел Прокофьевич", 2, 150000.0);
        book.add(welder);

        book.printMessage(Message.GETFORID);
        book.getEmployeeForId(3);

    }
}


