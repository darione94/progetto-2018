package siw.fullstack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siw.fullstack.model.Attivit‡;
import siw.fullstack.model.Allievo;
import siw.fullstack.service.Attivit‡Service;
import siw.fullstack.service.AllievoService;
import siw.fullstack.validator.Attivi‡Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@WebServlet("/productController")
public class Attivit‡Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		Attivit‡Service service = new Attivit‡Service();		
		// cancella il prodotto
		if (request.getParameter("delete") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Attivit‡ product = service.getOneProduct(id);
			service.deleteProduct(product);
			request.setAttribute("products", service.getAllProducts());
			nextPage = "/prodotti.jsp";
		// cancella tutti i prodotti
		} else if (request.getParameter("deleteAll") != null) {
			service.deleteAllProducts();
			request.setAttribute("products", service.getAllProducts());
			nextPage = "/prodotti.jsp";
		// salva il prodotto		
		} else if (request.getParameter("submit") != null) {
			Attivit‡ product = new Attivit‡();
			request.setAttribute("product", product);
			Attivi‡Validator validator = new Attivi‡Validator();
			if (validator.validate(request)) {
				service.insertProduct(product);
				nextPage = "/prodotto.jsp";
				setSuppliers(request);
			} else
				nextPage = "/nuovoProdotto.jsp";
		}
	    // aggiunge il fornitore al prodotto		
		else if (request.getParameter("aggiungi") != null){
			AllievoService serviceS = new AllievoService();
			Long idFornitore = Long.parseLong(request.getParameter("idF"));
			Allievo fornitore = serviceS.getOneSupplier(idFornitore);
			Long idProdotto = Long.parseLong(request.getParameter("id"));
			Attivit‡ product = service.getOneProduct(idProdotto);
			service.addSupplier(product, fornitore);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/prodotto.jsp";
		}
		// elimina il fornitore dalla lista dei fornitori del prodotto
		else {
			AllievoService serviceS = new AllievoService();
			Long idFornitore = Long.parseLong(request.getParameter("idF"));
			Allievo fornitore = serviceS.getOneSupplier(idFornitore);
			Long idProdotto = Long.parseLong(request.getParameter("id"));
			Attivit‡ product = service.getOneProduct(idProdotto);
			service.removeSupplier(product, fornitore);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/prodotto.jsp";
			
		}
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	private void setSuppliers(HttpServletRequest request){
		AllievoService serviceS = new AllievoService();
		List<Allievo> suppliers = serviceS.getAllSuppliers();
		request.setAttribute("suppliers", suppliers);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage ;
		Attivit‡Service service = new Attivit‡Service();
		
		// visualizzo il prodotto selezionato
		if (request.getParameter("id")!=null) {			
			Long id = Long.parseLong(request.getParameter("id"));
			Attivit‡ product = service.getOneProduct(id);
			request.setAttribute("product", product);
			setSuppliers(request);
			nextPage = "/prodotto.jsp";
		// visualizzo tutti i prodotti
		} else {
			request.setAttribute("products", service.getAllProducts());	
			nextPage = "/prodotti.jsp";
		}
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}