import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private long empId;

    public Developer(String name, long empId) {
        this.name = name;
        this.empId = empId;
    }
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name);
    }
}

class Manager implements Employee {
    private String name;
    private long empId;

    public Manager(String name, long empId) {
        this.name = name;
        this.empId = empId;
    }
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name);
    }
}

class CompanyDirectory implements Employee {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }
    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
    public void showEmployeeDetails() {
        for (Employee emp : employeeList) {
            emp.showEmployeeDetails();
        }
    }
}

// Usage
public class CompositePatternDemo {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Dev A", 1001);
        Developer dev2 = new Developer("Dev B", 1002);
        Manager mgr1 = new Manager("Manager X", 2001);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(dev1);
        directory.addEmployee(dev2);

        CompanyDirectory directory2 = new CompanyDirectory();
        directory2.addEmployee(mgr1);
        directory2.addEmployee(directory);

        directory2.showEmployeeDetails();
    }
}
