4.1. A simple Java program to store employee details (ID, Name, Salary) using an ArrayList. Users can add, update, remove, search, and display employees.
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: updateEmployee(); break;
                case 3: removeEmployee(); break;
                case 4: searchEmployee(); break;
                case 5: displayEmployees(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                scanner.nextLine();
                System.out.print("Enter New Name: ");
                e.name = scanner.nextLine();
                System.out.print("Enter New Salary: ");
                e.salary = scanner.nextDouble();
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.id == id);
        System.out.println("Employee removed successfully!");
    }

    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }
}
