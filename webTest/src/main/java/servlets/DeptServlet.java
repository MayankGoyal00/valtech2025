package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Employee;
import dao.EmployeeDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 


//import java.util.ArrayList;
//import java.util.List;
//import dao.Employee;
//import dao.EmployeeDAO;
//import dao.EmployeeDAOimpl;





@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;		//
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = (DeptDAO)config.getServletContext().getAttribute("Dept");
//		deptDAO= new DeptDAOimpl();
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation=req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("Dept", deptDAO.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
//		
//		age(Integer.parseInt(req.getParameter("age")))
//		.gender(req.getParameter("gender").toUpperCase())
//		.salary(Integer.parseInt(req.getParameter("salary")))
//		.experience(Integer.parseInt(req.getParameter("experience")))
//		.level(Integer.parseInt(req.getParameter("level")))
//		
		
		
		Dept dept =Dept.builder().DeptId(Integer.parseInt(req.getParameter("id")))
				.DeptName(req.getParameter("name"))
				.DeptAddress(req.getParameter("name")).build();
		
		if("Save".equals(operation)) {	
			deptDAO.save(dept);
			req.setAttribute("dept", deptDAO.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		if("Update".equals(operation)) {
			deptDAO.update(dept);
			req.setAttribute("dept", deptDAO.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		
		
//		HttpSession session=req.getSession();
//		Dept current=(Dept) session.getAttribute("current");
//		if(current == null) {
//			current=deptDAO.first();
//		} else {
//			if("First".equals(operation)) {
//				current = deptDAO.first();
//			} else if("Last".equals(operation)) {
//				current = deptDAO.last();
//			} else if("Previous".equals(operation)) {
//				current = deptDAO.previous(current.getId());
//			} else {
//				current = deptDAO.next(current.getId());
//			}
//		}
//		session.setAttribute("current", current);
//		//Expression in JSP can work with objects in session also...
//		req.setAttribute("dept", current);
//		//req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		
//		Cookie [] cookies = req.getCookies();
//		for(int i=0;i<cookies.length;i++) {
//			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
//		}
//		resp.addCookie(new Cookie("operation",operation));
//		//resp.addCookie(new Cookie("Company",operation));
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
	}
 
 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation =req.getParameter("operation");
		
			if("getAll".equals(req.getParameter("show"))) {
				List<Employee> dept = new ArrayList<>();  
				dept = DeptDAO.getAll();
				req.setAttribute("emps", DeptDAO.getAll());
				req.getRequestDispatcher("depts.jsp").forward(req, resp);
			
				return;
			}
		
		
			if("search".equals(operation)) {
			
			String searchType = req.getParameter("searchType");
			List<Employee> dept1=new ArrayList<>();
			
			if("DeptName".equals(searchType)) {
				String DeptName = req.getParameter("searchV");
				dept1 = DeptDAO.searchByName(DeptName);
			}else if("DeptId".equals(searchType)) {
				int DeptId = Integer.parseInt(req.getParameter("searchV"));
				dept1=DeptDAO.searchById(DeptId);
			}else if("DeptAddress".equals(searchType)) {
				String DeptAddress = req.getParameter("searchV");
				dept1 = DeptDAO.searchByDeptAddress(DeptAddress);
			}else
			{
				dept1=DeptDAO.getAll();
			}
			req.setAttribute("dept", dept1);
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
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
	 
			       List<Employee> dept = DeptDAO.sortEmployees(column, order);
			       req.setAttribute("dept", dept);
			       req.getRequestDispatcher("depts.jsp").forward(req, resp);
			       return;
			}
	
		if("Update".equals(operation)) {
			int DeptId = Integer.parseInt(req.getParameter("DeptId"));
			Employee e= DeptDAO.get(DeptId);
			System.out.println(e);
			req.setAttribute("emp", e);//
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);//
			return;
		}
		

	
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			DeptDAO.delete(id);
			req.setAttribute("emps", DeptDAO.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		
		
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("dept", DeptDAO.getAll());
		req.getRequestDispatcher("depts.jsp").forward(req, resp); 
	
		
		//		req.setAttribute("dept", deptDAO.first());
//		HttpSession session=req.getSession();
//		session.setAttribute("current",deptDAO.first());
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
	}
}
 
