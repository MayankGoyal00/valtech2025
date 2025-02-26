package servlets;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
 
import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOimpl;
import jakarta.servlet.ServletContext;
 
public class DeptDAOImpl implements DeptDAO  {
	ServletContext sc;

	public DeptDAOImpl(ServletContext sc) {
		this.sc = sc;
	}
 
	private Connection getConnection(ServletContext sc) throws SQLException {
		System.out.println("dd----dd----"+sc);
		String url = (String)sc.getAttribute("url");
		String user = (String)sc.getAttribute("user");
		String password = (String)sc.getAttribute("password");
		return DriverManager.getConnection
				(url,user,password);
		}

	@Override
	public void save(Dept d) {
		try(Connection conn = getConnection(this. sc)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO DEPT (DEPT_ID,DEPT_NAME,LOCATION) VALUES(?,?,?)") ;
			setValuesToPreparedStatement(d,ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted + "+ rowsAffected);
		} 
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
		private void  setValuesToPreparedStatement(Dept d, PreparedStatement ps) throws SQLException {
			ps.setInt(1,d.getId());
			ps.setString(2, d.getName());
			ps.setString(3,d.getLocation());
 
		}
 
		@Override
		public Dept first() {
			DeptDAOImpl dept=new DeptDAOImpl(sc);
			System.out.println(dept);
		return dept.getAll().stream().min((a,b)->(a.getId()-b.getId())).get();
		}
 
		@Override
		public Dept last() {
			DeptDAOImpl dept=new DeptDAOImpl(sc);
 
			return dept.getAll().stream().max((a,b)->(a.getId()-b.getId())).get();
		}
 
		@Override
		public Dept next(int id) {
			DeptDAOImpl dept=new DeptDAOImpl(sc);
 
			if (id==dept.getAll().size()) {
				return getDept(id);
			}
			return getDept(id+1);
		}
 
		@Override
		public Dept previous(int id) {
			if (id ==1) {
				return getDept(1);
			} 
			return getDept(id-1);
		}
 
		@Override
		public void update(Dept d) {
			try(Connection conn = getConnection(this.sc)){
				PreparedStatement ps = conn.prepareStatement("UPDATE DEPT SET DEPT_ID=?,DEPT_NAME=?,LOCATION=? WHERE ID = ? ");
				setValuesToPreparedStatement(d, ps);
				int rowsAffected = ps.executeUpdate();
				System.out.println("Rows Updated = "+rowsAffected);
				} catch(Exception ex) {
				throw new RuntimeException(ex);
	}
}
		@Override
		public Dept getDept(int id) {
			try(Connection conn = getConnection(this.sc)){
				PreparedStatement ps = conn.prepareStatement("SELECT DEPT_ID,DEPT_NAME,LOCATION FROM DEPT WHERE DEPT_ID =?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Dept d = populateDept(rs);
					return d;
				} else {
					new RuntimeException("No Dept with id" + id + "Found");
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			return null;
		}
 
		@Override
		public void delete(int id) {
			try(Connection conn = getConnection(this.sc)){
				PreparedStatement ps = conn.prepareStatement 
						("DELETE FROM EMPLOYEE WHERE ID =?");
				ps.setInt(1, id);
				int rows = ps.executeUpdate();
				System.out.println("Rows Deleted +" + rows);
			} catch(Exception ex) {
				throw new RuntimeException(ex);
	}
}
		public List<Employee> ShowEmployeeById(int dept_id) {
			List<Employee> emp = new ArrayList<Employee>();
			try(Connection conn = getConnection(this.sc)){
				PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,SALARY,GENDER,LEVEL,EXPERIENCE,DEPT_ID FROM EMPLOYEE WHERE DEPT_ID = ?");
				System.out.println(ps);
				ps.setInt(1, dept_id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					emp.add(populateEmp(rs));
				}	
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			System.out.println("----"+emp);
			return emp;
		}


		private Employee populateEmp (ResultSet rs) throws SQLException {
			return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3))
					.gender(rs.getString(5)).salary(rs.getFloat(4)).experience(rs.getInt(7)).level(rs.getInt(6)).id(rs.getInt(8)).build();
		}
 
		private Dept populateDept (ResultSet rs) throws SQLException {
			return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build(); 
		}

 
		@Override
		public List<Dept> getAll() {
			List<Dept> depts = new ArrayList<Dept>();
			try(Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement 
					("SELECT DEPT_ID,DEPT_NAME,LOCATION FROM DEPT");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				depts.add(populateDept(rs));
				}
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
			return depts;
		}	

}

