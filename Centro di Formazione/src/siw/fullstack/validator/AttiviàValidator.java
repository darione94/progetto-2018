package siw.fullstack.validator;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import siw.fullstack.model.Attivitā;
import siw.fullstack.model.Allievo;

public class AttiviāValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		ArrayList<Allievo> suppliers = new ArrayList<Allievo>();
		Attivitā product = (Attivitā)request.getAttribute("product");
		
		product.setSuppliers(suppliers);
		
		if(name == null || name.equals("")) {
			request.setAttribute("errName", "Campo obbligatorio");
			tuttoOk = false;
		} else
			product.setName(name);
		
		if(description == null || description.equals("")) {
			request.setAttribute("errDesc", "Campo obbligatorio");
			tuttoOk = false;
		} else
			product.setDescription(description);
		
		if(price == null || price.equals("")) {
			request.setAttribute("errPrice", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				product.setPrice(Float.parseFloat(price));
			} catch (NumberFormatException e) {
				request.setAttribute("errPrice", "Deve essere un numero!");
				tuttoOk = false;
			}
		}	
		return tuttoOk;
	}
}