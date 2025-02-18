package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmaticServlet extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content="""
				<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="arithmatic" method="post">
	A=<input type="text" name="a"/><br/>
	B=<input type="text" name="b"/><br/>
	<input type="submit" name ="operation" value="Add"/>
	<input type="submit" name ="operation" value="Sub"/>
	<input type="submit" name ="operation" value="Mul"/>
	<input type="submit" name ="operation" value="Div"/>
	
</form>
</body>
</html>
				""";
		
		resp.getWriter().print(content);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer a = Integer.parseInt(req.getParameter("a"));
		Integer b = Integer.parseInt(req.getParameter("b"));
		String operation = req.getParameter("operation");
		//only call business logic ...  don't write business logic ... 
		
		int result=0;
		if("Add".equals(operation)) {
			result = a+b;
			
		}else if("Sub".equals(operation)) {
			result =a-b;
		
		}else if("Mul".equals(operation)) {
			result=a*b;
		}else {
			result =a/b;
		}
		//MessageFormat mf= new MessageFormat("A= {} {} B= {} = {} ");
		System.out.println(MessageFormat.format("A= {0}, {1} B = {2}, = {3} hellovxhgxhwxfw",a,operation,b,result));//"A="+a+" "+ operation +"B="+b+" "+ result
		//
		//we need to store and pass the result to arithmatic.jsp page
		// we have to go to the arithmatic.jsp page 
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmatic.jsp").forward(req,resp);
		
		//		String content="""
//				<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//A={0}<br/>
//B={1}<br/>
//Operation ={2}<br/>
//Result={3}<br/>
//<form action ="arithmatic" method="post">
//	A=<input type="text" name="a"/><br/>
//	B=<input type="text" name="b"/><br/>
//	<input type="submit" name ="operation" value="Add"/>
//	<input type="submit" name ="operation" value="Sub"/>
//	<input type="submit" name ="operation" value="Mul"/>
//	<input type="submit" name ="operation" value="Div"/>
//	
//</form>
//</body>
//</html>
//				""";
//		PrintWriter out=resp.getWriter();
//		out.print(MessageFormat.format(content, a,b,operation,result));
	}
}
