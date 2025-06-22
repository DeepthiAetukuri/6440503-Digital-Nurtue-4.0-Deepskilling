import java.util.Scanner;
public class EmployeeManagementSystem {
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return employeeId + " - " + name + " - " + position + " - Rupees " + salary;
        }
    }
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;  
    public static void addEmployee(Employee emp) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = emp;
        } else {
            System.out.println("Employee list is full.");
        }
    }
    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }
    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    public static void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addEmployee(new Employee(1, "Deepthi", "Manager", 75000));
        addEmployee(new Employee(2, "Preethi", "Developer", 55000));
        addEmployee(new Employee(3, "Anu", "Analyst", 50000));
        System.out.println("All Employees:");
        displayAllEmployees();
        System.out.println("\nSearching for Employee with ID 2:");
        Employee found = searchEmployee(2);
        System.out.println(found != null ? "Found: " + found : "Not found.");
        System.out.println("\nDeleting Employee with ID 1...");
        deleteEmployee(1);
        displayAllEmployees();
        sc.close();
    }
}
