package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;

import util.Service;

public class TestServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = new Service();
		ServerContext wctx = ServerContextFactory.get(this.getServletContext());
		for (int i = 0; i < 1000; i++) {
			service.update(wctx);
			try {
				Thread.sleep(1000);
				System.out.println("In side tread.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		PrintWriter writer = response.getWriter();
		writer.println("Done");
		writer.close();

	}
}