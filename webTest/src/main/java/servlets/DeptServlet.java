package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.Employee;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@WebServlet(urlPatterns = "/depts")

public class DeptServlet extends HttpServlet {


	private DeptDAO deptDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletContext()+"ooii");
		System.out.println(config);
		deptDAO = new DeptDAOImpl(config.getServletContext());
		System.out.println(config.getServletContext()+"ooii");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		if(current == null) { current = deptDAO.first();

	} else {
		if("First".equals(operation)) {
			current = deptDAO.first();
			} else if ("Last".equals(operation)) {
				current = deptDAO.last();
		} else if ("Previous".equals(operation)) {
		current = deptDAO.previous(current.getId());
	} else if ("Next".equals(operation)){
		current = deptDAO.next(current.getId());
			}
	}
		session.setAttribute("current",current);
		req.setAttribute("dept",current);
		req.setAttribute("emp",deptDAO.ShowEmployeeById(current.getId()));
		Cookie [] cookies = req.getCookies();
		for (int i =0; i < cookies.length;i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("dept", deptDAO.first());
		HttpSession session = req.getSession();
		session.setAttribute("current",deptDAO.first() );
		Dept current = (Dept)session.getAttribute("current");
		Dept dept = deptDAO.first();
		req.setAttribute("emp",deptDAO.ShowEmployeeById(dept.getId()));
		req.getRequestDispatcher("depts.jsp").forward(req,resp);
	}
}
