package miniprojet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniprojet.model.Person;
import miniprojet.model.authen;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Voici un utilisateur : meme review");
		authen authentication = new authen();
		String deco = request.getParameter("deconnect");
		
		Person random = new Person(request.getParameter("username"),request.getParameter("password"));
		
		try {
			if(authentication.verify(random)) {
				System.out.println("Connexion validée");
				this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
			}
			
			else if (deco != null && deco.equals("Deconnecter")) {
                this.getServletContext().getRequestDispatcher("/goodbye.jsp").forward(request, response);;

            }
			
			
			else {
				System.out.println("Connexion refusée");
				this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ArrayList<Person> n = authentication.read();
			for(Person p:n) {
				System.out.println(p.getName() + "  " + p.getPass());
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
//		if(random.getName().equals(request.getParameter("username")) && random.getPass().equals(request.getParameter("password"))) {
//			
//			System.out.println("Connexion validée");
//			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
//		}
//		else {
//			
//			System.out.println("Connexion refusée");
//			this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
//		}
		
		doGet(request, response);
	}
	
	
}
