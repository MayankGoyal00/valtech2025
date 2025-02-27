package servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("First piece of code...");
		System.out.println("load...");
		System.out.println("Database Connection...");
		ServletContext application = sce.getServletContext();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database Connection...");
	}
	
}