import java.util.*;

// Abstract Class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// FullTimeEmployee Class
class FullTimeEmployee extends Employee implements Department {
    private double fixedSalary;
    private String department;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee Class
class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee fte = new FullTimeEmployee(101, "Akshit", 500000, 20000);
        fte.assignDepartment("IT");
        
        PartTimeEmployee pte = new PartTimeEmployee(102, "Harsh", 200000, 20, 500);
        pte.assignDepartment("HR");
        
        employees.add(fte);
        employees.add(pte);
        
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("----------------------");
        }
    }
}
