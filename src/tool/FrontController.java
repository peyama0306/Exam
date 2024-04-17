package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *Srvlet implementation class FrontController
 */
@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req,res);
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{

			String path = req.getServletPath().substring(1);

			String name = path.replace("a", "A").replace('/', '.');

			System.out.println("★ servlet path ->" + req.getServletPath());
			System.out.println("★ class name ->" + name);

			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();

			action.execute(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req,res);
	}
		res.getWriter().append("Served at:").append(req.getContextPath());
	}
	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stud
		doGet(request,response);
	}
}