package com.employee.EmployeeBook;

import java.util.*;

public class EmployeeData {
    public static int[] departments = new int[]{1,2,3,4,5};
    public static Map<String, Employee> employees = new HashMap<>(Map.of(
            "Пугачёва Алла", new Employee("Пугачёва", "Алла", departments[0], 465000),
            "Киркоров Филипп", new Employee("Киркоров", "Филипп",  departments[0], 455000),
            "Козлов Игорь", new Employee("Козлов", "Игорь",  departments[1], 225000),
            "Козлов Иван", new Employee("Козлов", "Иван", departments[1], 125000),
            "Бронина Виктория", new Employee("Бронина", "Виктория", departments[1], 120000),
            "Козлов Святослав", new Employee("Козлов", "Святослав", departments[2], 156000),
            "Восточная Марина", new Employee("Восточная", "Марина", departments[3], 110000),
            "Васильева Эльвира", new Employee("Васильева", "Эльвира", departments[4], 75000),
            "Сухорукова Светлана", new Employee("Сухорукова", "Светлана", departments[3], 138000),
            "Сухоруков Вячеслав", new Employee("Сухоруков", "Вячеслав", departments[2], 120000)
    ));
}
