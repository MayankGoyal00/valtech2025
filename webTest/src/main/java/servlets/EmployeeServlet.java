package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOimpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns ="/employees")
public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
	    ServletContext context = getServletContext();
	    Properties properties = new Properties();
	    try (InputStream input = context.getResourceAsStream("/WEB-INF/classes/db.properties")) {
	        if (input != null) {
	            properties.load(input);
	        } else {
	            throw new ServletException("Could not load properties file.");
	        }
	    } catch (IOException e) {
	        throw new ServletException("Error loading properties", e);
	    }
 
	    dao = new EmployeeDAOimpl(context, properties);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation =req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		Employee emp=Employee.builder().id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(req.getParameter("gender").toUpperCase())
				.salary(Integer.parseInt(req.getParameter("salary")))
				.experience(Integer.parseInt(req.getParameter("experience")))
				.level(Integer.parseInt(req.getParameter("level"))).build();
		
		if("Save".equals(operation)) {
			
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		if("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation =req.getParameter("operation");
		
			if("getAll".equals(req.getParameter("show"))) {
				List<Employee> emps = new ArrayList<>();  
				emps = dao.getAll();
				req.setAttribute("emps", dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
			
				return;
			}
		
		
			if("search".equals(operation)) {
			
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchV");
	        String sortCondition = req.getParameter("sortCondition");
	   
	        
			
			List<Employee> emp1=new ArrayList<>();
			
			if("name".equals(searchType)) {
				String name = req.getParameter("searchV");
                emp1 = dao.searchByName(name);
                
                
			}else if("ID".equals(searchType)) {
				int id = Integer.parseInt(req.getParameter("searchV"));
				emp1=dao.searchById(id);
				
				
				
			}else if("age".equals(searchType)) {
				int age = Integer.parseInt(req.getParameter("searchV"));
				String condition = req.getParameter("AgeSort");
				emp1=dao.searchByAge(age,sortCondition);
				
				
				
			}else if("gender".equals(searchType)) {
				String gender = req.getParameter("searchV");
				emp1=dao.searchByGender(gender);
				
				
			}else if("salary".equals(searchType)) {
				float salary = Float.parseFloat(req.getParameter("searchV"));
				String condition = req.getParameter("salarySort");
				emp1=dao.searchBySalary(salary,sortCondition);
				
				
			}else if("level".equals(searchType)) {
				int level = Integer.parseInt(req.getParameter("searchV"));
				String condition = req.getParameter("levelSort");
				emp1=dao.searchByLevel(level,sortCondition);
				
			
			}else if("experience".equals(searchType)) {
				int experience = Integer.parseInt(req.getParameter("searchV"));
				String condition = req.getParameter("experienceSort");
				emp1=dao.searchByExperience(experience, sortCondition);
			}else
			{
				emp1=dao.getAll();
			}
			req.setAttribute("emps", emp1);
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
			
		}
			
			if("sort".equals(operation)) {
				HttpSession session = req.getSession();
				String column = req.getParameter("column");
				String currentOrder = (String) session.getAttribute("sortOrder");
				String currentColumn = (String) session.getAttribute("sortColumn");
				
				String order = "ASC" ;
				if(column.equals(currentColumn)) {
					order = "DESC".equals(currentOrder) ? "ASC" : "DESC";	
				}
				  session.setAttribute("sortColumn", column);
			      session.setAttribute("sortOrder", order);
	 
			       List<Employee> emps = dao.sortEmployees(column, order);
			       req.setAttribute("emps", emps);
			       req.getRequestDispatcher("employees.jsp").forward(req, resp);
			       return;
			}
		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e= dao.get(id);
			System.out.println(e);
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		
		
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp); 
		
	}

}