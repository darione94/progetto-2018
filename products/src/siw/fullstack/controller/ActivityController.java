package siw.fullstack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siw.fullstack.model.Activity;
import siw.fullstack.model.Student;
import siw.fullstack.service.ActivityService;
import siw.fullstack.service.StudentService;
import siw.fullstack.validator.ActivityValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@WebServlet("/productController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		ActivityService service = new ActivityService();		
		// cancella il prodotto
		if (request.getParameter("delete") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Activity product = service.getOneProduct(id);
			service.deleteProduct(product);
			request.setAttribute("products", service.getAllProducts());
			nextPage = "/attivitas.jsp";
		// cancella tutti i prodotti
		} else if (request.getParameter("deleteAll") != null) {
			service.deleteAllProducts();
			request.setAttribute("products", service.getAllProducts());
			nextPage = "/attivitas.jsp";
		// salva il prodotto		
		} else if (request.getParameter("submit") != null) {
			Activity product = new Activity();
			request.setAttribute("product", product);
			ActivityValidator validator = new ActivityValidator();
			if (validator.validate(request)) {
				service.insertProduct(product);
				nextPage = "/attivita.jsp";
				setSuppliers(request);
			} else
				nextPage = "/nuovaAttivita.jsp";
		}
	    // aggiunge il fornitore al prodotto		
		else if (request.getParameter("aggiungi") != null){
			StudentService serviceS = new StudentService();
			Long idFornitore = Long.parseLong(request.getParameter("idF"));
			Student fornitore = serviceS.getOneSupplier(idFornitore);
			Long idProdotto = Long.parseLong(request.getParameter("id"));
			Activity product = service.getOneProduct(idProdotto);
			service.addSupplier(product, fornitore);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/attivita.jsp";
		}
		// elimina il fornitore dalla lista dei fornitori del prodotto
		else {
			StudentService serviceS = new StudentService();
			Long idFornitore = Long.parseLong(request.getParameter("idF"));
			Student fornitore = serviceS.getOneSupplier(idFornitore);
			Long idProdotto = Long.parseLong(request.getParameter("id"));
			Activity product = service.getOneProduct(idProdotto);
			service.removeSupplier(product, fornitore);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/attivita.jsp";
			
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	private void setSuppliers(HttpServletRequest request){
		StudentService serviceS = new StudentService();
		List<Student> suppliers = serviceS.getAllSuppliers();
		request.setAttribute("suppliers", suppliers);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/attivitas.jsp";
		ActivityService service = new ActivityService();
		
		// visualizzo il prodotto selezionato
		if (request.getParameter("id")!=null) {			
			Long id = Long.parseLong(request.getParameter("id"));
			Activity product = service.getOneProduct(id);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/attivita.jsp";
		// visualizzo tutti i prodotti
		} else {
			List<Activity> products = service.getAllProducts();
			request.setAttribute("products", products);	
		}
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}