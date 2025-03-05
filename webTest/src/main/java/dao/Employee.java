package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee>{
	
	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int experience;
	private Gender gender;		//enum 
	public static List<Employee> allEmp = new ArrayList<Employee>();
	public static Map<Gender,List<Employee>> getEmployeeMap = new HashMap<Gender,List<Employee>>();

	public Employee() {
	}

	public Employee(long id, String name, int age, float salary, int level, int experience, Gender gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.experience = experience;
		this.gender = gender;
	}

	public static Map<Gender,List<Employee>> getemployeebygender(){
		return allEmp.stream().collect(Collectors.groupingBy(e->e.gender));
	}

	public static double getemployeebylevel(int level) {
		List<Employee> emp= allEmp.stream().filter(e->e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.level==level).mapToDouble(Employee::getSalary).sum();
	}

	public static double getemployeebygender(Gender gender) {
		List<Employee> emp= allEmp.stream().filter(e->e.gender.equals(gender)).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender)).mapToDouble(Employee::getSalary).sum();
	}

	public static String getemployeebyname(String name) {
		List<Employee> emp= allEmp.stream().filter(e->e.name.equals(name)).collect(Collectors.toList());
		System.out.println(emp);
		double emp1= allEmp.stream().filter(e->e.name.equals(name)).mapToDouble(Employee::getSalary).sum();
		if(emp1>0) {
			return "Total = "+emp1;
		}
		else {
			return "Not available "+name;
		}
	}

	public static double getemployeebygenderlevel(int level, Gender gender) {
		List<Employee> emp= allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).mapToDouble(Employee::getSalary).sum();
	}
	
	
	
	
	public enum Gender {

		MALE, FEMALE, OTHER;
	}
	

	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}


	
	@Override
	public String toString() {
		return "Employee id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", level=" + level
				+ ", experience=" + experience + " Gender="+gender;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
	


	public static EmployeeBuilder builder() {
		
		EmployeeBuilder empb=new EmployeeBuilder(new Employee());
		return (empb);
	}
	
	public static class EmployeeBuilder{
		private Employee employee;
		
		public EmployeeBuilder(Employee employee) {
			this.employee=employee;
		}
		public Employee build() {
			allEmp.add(employee);
			return employee;
		}
		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}
		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		} 
		public EmployeeBuilder experience(int experience) {
			employee.setExperience(experience);
			return this;
		}
		public EmployeeBuilder gender(String gender) {
			//employee.setGender(gender);
			employee.setGender(Gender.valueOf(gender));
			return this;
		}
		
	}

	//Gender.valueOf(rs.getString(4));
	
	
	
	@Override
	public int compareTo(Employee o) {
		if(this.level != o.level) 
			return level-o.level;
		else if(this.experience != o.experience )
			return experience-o.experience;
		int genderComparable = this.gender.compareTo(o.gender);
		if(genderComparable != 0) return genderComparable;
			return (int) (salary-o.salary); 
		
	}

	public static void main(String[] args) {
		Employee ob =new Employee(2l, "mayank", 23, 1000, 3, 6, Gender.MALE);
		System.out.println(ob.toString());
		
	}
}