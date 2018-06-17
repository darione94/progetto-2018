package siw.fullstack.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siw.fullstack.model.Student;
import siw.fullstack.service.StudentService;
import siw.fullstack.validator.StudentValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@WebServlet("/supplierController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		StudentService service = new StudentService();
		
		// cancella un fornitore
		if (request.getParameter("delete") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Student supplier = service.getOneSupplier(id);
			service.deleteSupplier(supplier);
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/allievi.jsp";
		// cancella tutti i fornitori
		} else if (request.getParameter("deleteAll") != null) {
			service.deleteAllSuppliers();
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/allievi.jsp";
		// salva un nuovo fornitore
		} else {
			Student supplier = new Student();
			request.setAttribute("supplier", supplier);
			StudentValidator validator = new StudentValidator();
			if (validator.validate(request)) {
				service.insertSupplier(supplier);
				nextPage = "/allievo.jsp";
			} else
				nextPage = "/nuovoAllievo.jsp";
		}
			
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		StudentService service = new StudentService();
		
		// visualizza il fornitore selezionato
		if (request.getParameter("id")!=null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Student supplier = service.getOneSupplier(id);
			request.setAttribute("supplier", supplier);
			nextPage = "/allievo.jsp";
		// mostra tutti i fornitori
		} else {
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/allievi.jsp";
		}
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}