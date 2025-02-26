package spring.Tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.AutoClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.Tx.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	@Autowired
	private DataSource datasource;
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	private Connection getConnection() throws SQLException{
		return datasource.getConnection();
		//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
	}
	
	
	
	
	
	@Override
	public void save(Employee e) {
		new JdbcTemplate(datasource).update("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)",e.getName(),e.getAge(),e.getGender().name(),e.getSalary(),e.getExperience(),e.getLevel(),e.getId());
//		try (Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)");
//			setValuesToPreparedStatement(e, ps);
//			int rowsAffected=ps.executeUpdate();
//			System.out.println("ROW Insert = "+rowsAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		
	}

	
	
	
	@Override
	public void update(Employee e) {
		new JdbcTemplate(datasource).update("UPDATE EMPLOYEE SET NAME = ?, AGE=?, GENDER=?, SALARY=?, EXPERIENCE=?, LEVEL=? WHERE ID = ?",e.getName(),e.getAge(),e.getGender().name(),e.getSalary(),e.getExperience(),e.getLevel());
//		try (Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME = ?, AGE=?, GENDER=?, SALARY=?, EXPERIENCE=?, LEVEL=? WHERE ID = ?");
//			
//			setValuesToPreparedStatement(e, ps);
//			int rowsAffected=ps.executeUpdate();
//			System.out.println("ROW Updated = "+rowsAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
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
		new JdbcTemplate(datasource).update("DELETE FROM EMPLOYEE WHERE ID =?",id);

//		try (Connection conn = getConnection()){
//			PreparedStatement ps=conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID =?");
//			ps.setInt(1,id);
//			int rowAffected =ps.executeUpdate();
//			System.out.println("deleted row ="+ rowAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return ;
	}

	
	
	
	
	@Override
	public Employee get(int id) {
		return new JdbcTemplate(datasource).queryForObject("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?",new Object[] {id}, new EmployeeRowMapper());
//		try (Connection conn = getConnection()){
//			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?");
//			ResultSet rs=ps.executeQuery();
//			if(rs.next())
//			if(rs.next()) {//if true another row else at he end of resultset
//				Employee e= populateEmployee(rs);
//			}else {
//				new RuntimeException("NO employee ID "+id+"found");
//			}
//			
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return null;
	}
	
	
	private Employee populateEmployee(ResultSet rs)throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(rs.getString(4)).salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
	}

	
	

	
	
	@Override
	public List<Employee> getAll() {
		return new JdbcTemplate(datasource).query("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE",new EmployeeRowMapper());
//		List<Employee> emps=new ArrayList<Employee>();
//		try(Connection conn = getConnection()) {
//			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				emps.add(populateEmployee(rs));
//			}
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return emps;
	}
	
	
	private static class EmployeeRowMapper implements RowMapper<Employee>{
		 
		@Override
		public Employee mapRow(ResultSet rs, int index) throws SQLException {
			
			return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(rs.getString(4))
					.salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
		}
		
	}

}










