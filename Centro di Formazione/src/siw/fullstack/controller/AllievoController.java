package siw.fullstack.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siw.fullstack.model.Allievo;
import siw.fullstack.service.AllievoService;
import siw.fullstack.validator.AllievoValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@WebServlet("/supplierController")
public class AllievoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		AllievoService service = new AllievoService();
		
		// cancella un fornitore
		if (request.getParameter("delete") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Allievo supplier = service.getOneSupplier(id);
			service.deleteSupplier(supplier);
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/fornitori.jsp";
		// cancella tutti i fornitori
		} else if (request.getParameter("deleteAll") != null) {
			service.deleteAllSuppliers();
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/fornitori.jsp";
		// salva un nuovo fornitore
		} else {
			Allievo supplier = new Allievo();
			request.setAttribute("supplier", supplier);
			AllievoValidator validator = new AllievoValidator();
			if (validator.validate(request)) {
				service.insertSupplier(supplier);
				nextPage = "/fornitore.jsp";
			} else
				nextPage = "/nuovoFornitore.jsp";
		}
			
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		AllievoService service = new AllievoService();
		
		// visualizza il fornitore selezionato
		if (request.getParameter("id")!=null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Allievo supplier = service.getOneSupplier(id);
			request.setAttribute("supplier", supplier);
			nextPage = "/fornitore.jsp";
		// mostra tutti i fornitori
		} else {
			request.setAttribute("suppliers", service.getAllSuppliers());
			nextPage = "/fornitori.jsp";
		}
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}