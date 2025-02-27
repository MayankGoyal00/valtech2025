package dao;


import jakarta.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import day4.Employee;

public class EmployeeDAOimpl implements EmployeeDAO{
	
//	private Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
//	}
//	
	public EmployeeDAOimpl(ServletContext sce,Properties p){
        this.sce = sce;
        this.p=p;
    }
	
	
	
	private ServletContext sce;
	private Properties p;
	
	
	public ServletContext getSce() {
		return sce;
	}


	public void setSce(ServletContext sce) {
		this.sce = sce;

	}
	
	
//	(String)sce.getAttribute("db.password")"
	private Connection getConnection()  throws SQLException{
		System.out.println(sce.getAttribute("db.password"));
		String pass=(String)sce.getAttribute("db.password");
		System.out.println(pass);
		return DriverManager.getConnection((String)sce.getAttribute("db.url"),(String)sce.getAttribute("db.username"),(String)sce.getAttribute("db.password"));
//		return DriverManager.getConnection((String)sce.getAttribute("db.url"), p);
	}
	
	
	
	
	@Override
	public List<Employee> searchByName(String name) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE NAME LIKE ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(name);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public List<Employee> searchByAge(int age) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE AGE =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, age);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	
	
	@Override
	public List<Employee> searchByGender(String gender) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE GENDER = ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setString(1, gender);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	
	
	@Override
	public List<Employee> searchBySalary(float salary, String condition) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE SALARY " + condition + " ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setFloat(1, salary);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
 
	@Override
	public List<Employee> searchByLevel(int level) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE LEVEL =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, level);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
 
	@Override
	public List<Employee> searchByExperience(int ex) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE EXPERIENCE =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, ex );
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps By Experience"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
 
	@Override
	public List<Employee> searchById(long id) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	@Override
	public List<Employee> sortEmployees(String column,String order) {
		List<Employee> emps = new ArrayList<>();
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE ORDER BY " + column + " " + order);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps;
	}

	


	@Override
	public void save(Employee e) {
		try (Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("ROW Insert = "+rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}

	
	
	@Override
	public void update(Employee e) {
		
		try (Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME = ?, AGE=?, GENDER=?, SALARY=?, EXPERIENCE=?, LEVEL=? WHERE ID = ?");
			
			setValuesToPreparedStatement(e, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("ROW Updated = "+rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setDouble(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
	}
	

	
	@Override
	public void delete(int id) {
		try (Connection conn = getConnection()){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID =?");
			ps.setInt(1,id);
			int rowAffected =ps.executeUpdate();
			System.out.println("deleted row ="+ rowAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return ;
	}

	
	
	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection()){
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//if true another row else at he end of resultset
				Employee e= populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("NO employee ID "+id+"found");
			}
		} catch (Exception ex) {
		
			
			throw new RuntimeException(ex);
		}
		return null;
	}
	private Employee populateEmployee(ResultSet rs)throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(rs.getString(4)).salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
	}

	
	
	
	
	@Override
	public List<Employee> getAll() {
		List<Employee> emps=new ArrayList<Employee>();
		try(Connection conn = getConnection()) {
			System.out.println("Connection Done");
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps;
	}

}