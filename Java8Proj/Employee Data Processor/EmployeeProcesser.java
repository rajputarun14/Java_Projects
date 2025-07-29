import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeProcesser {
    public static void main(String args[])
    {
        List<Employee> employees = new ArrayList<>();
        try
        {
            employees = Files.lines(Paths.get("employees.csv")).
            skip(1)
            .map(line -> line.split(","))
            .map(data -> new Employee(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]),
            Integer.parseInt(data[4]))).collect(Collectors.toList());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        List<Employee> sortedEmp = sortAsPerAge(employees);
        List<Employee> dEmployees = employeeListPerDepartment(employees,"HR");
        for(Employee emp : dEmployees)
        {
            System.out.println(emp.getName() + "  Department: " + emp.getDepartment());
        }

        List<Employee> emps = employees.stream().filter(emp -> emp.getName().equalsIgnoreCase("arun")).collect(Collectors.toList());
        for (Employee employee : emps) {
            System.out.println(employee);
        }

        List<Employee> salariedEmps50 = employeesGreaterSalary(employees, 50000);
        for(Employee employee : salariedEmps50) {
            System.out.println(employee);
        }

        //Highest salary
        System.out.println(highestSalary(employees));
       // employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(emp -> System.out.println(emp)); 

       //departmentWiseEmployees
        Map<String, List<Employee>> departmentWiseEmployees = departMentWiseEmployees(employees);

        for(Map.Entry<String, List<Employee>> ent : departmentWiseEmployees.entrySet())
        {
            System.out.println("Department name: "+ent.getKey() +". No Of Employes " + ent.getValue().size());
        }
        List<Employee> empss = nameToUpperCase(employees);
        for(Employee emp : empss)
        {
            System.out.println(emp.getName());
        }

        boolean hasHighEarner = employees.stream()
        .anyMatch(emp -> emp.getSalary() > 100000);

        boolean allAdults = employees.stream()
        .allMatch(emp -> emp.getAge() > 18);

        boolean noInterns = employees.stream()
        .noneMatch(emp -> emp.getDepartment().equalsIgnoreCase("Eng"));
    }
    public static Optional<Employee> highestSalary(List<Employee> employees)
    {
        Optional<Employee> sal = employees.stream().max(Comparator.comparing(Employee::getSalary)); 
        return sal;
    }
    public static Map<String, List<Employee>> departMentWiseEmployees(List<Employee> employees)
    {
        Map<String, List<Employee>> departmentWiseEmployees = 
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        return departmentWiseEmployees;
    }
    public static List<Employee> employeeListPerDepartment(List<Employee> employees, String department)
    {
        return employees.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }
    public static List<Employee> nameToUpperCase(List<Employee> employees)
    {
        employees.forEach(emp -> emp.setName(emp.getName().toUpperCase()));
        return employees;
    }
    public static List<Employee> employeesGreaterSalary(List<Employee> employees, int salary)
    {
        return employees.stream().filter(emp -> emp.getSalary() > salary).collect(Collectors.toList());
    }
    public static List<Employee> sortAsPerAge(List<Employee> employees)
    {
        return employees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
    }
}
