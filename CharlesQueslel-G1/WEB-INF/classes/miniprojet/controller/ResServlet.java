package miniprojet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniprojet.model.Book;
import miniprojet.model.Person;
import miniprojet.model.Reservation;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reservation res = new Reservation();
		RequestDispatcher dis = null;
		String actionner = request.getParameter("okk");
        String conf = request.getParameter("retour");
		
//		Book book1 = new Book("Les Miserables",false, null);
//		Book book2 = new Book("Le Petit Prince",false, null);
//		Book book3 = new Book("Le Rouge et le Noir",false, null);
//		Book book4 = new Book("Sans Famille",false, null);
//		Book book5 = new Book("La Peste",false, null);
//		Book book6 = new Book("L'Etranger",false, null);
//		
//		try {
//			res.registerBook(book1);
//			res.registerBook(book2);
//			res.registerBook(book3);
//			res.registerBook(book4);
//			res.registerBook(book5);
//			res.registerBook(book6);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Book rando = new Book(request.getParameter("bookname"));
		
		request.setAttribute("rando", rando);
		
		
		
		try {
			if(res.verifyBook(rando)) {
				System.out.println("Livre trouvé");
				
				dis = getServletContext().getRequestDispatcher("/books.jsp");
			}
			
			  else if (actionner!=null && actionner.equals("reserve")) {
	                rando = new Book(request.getParameter("okkk"));
	                res.Reserver(rando);
	                request.setAttribute("rando", rando);
	                dis = getServletContext().getRequestDispatcher("/confirmation.jsp");


	            }
	            else if (conf != null && conf.equals("Retour")) {
	                rando = new Book(request.getParameter("bookname"));
	                request.setAttribute("rando", rando);

	                dis = getServletContext().getRequestDispatcher("/books.jsp");

	            }
			
			else {
				System.out.println("Livre introuvable");
				
				dis = getServletContext().getRequestDispatcher("/error.jsp");
			}
			dis.include(request, response);
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			
		try {
			ArrayList<Book> n = res.readBook();
			for(Book p:n) {
				System.out.println(p.getName());
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		doGet(request, response);
	}

}
