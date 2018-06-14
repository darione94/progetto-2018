package siw.fullstack.validator;



import javax.servlet.http.HttpServletRequest;

import siw.fullstack.model.Allievo;

public class AllievoValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Allievo supplier = (Allievo)request.getAttribute("supplier");
		
		if(name == null || name.equals("")) {
			request.setAttribute("errName", "Campo obbligatorio");
			tuttoOk = false;
		} else
			supplier.setName(name);
		
		if(surname == null || surname.equals("")) {
			request.setAttribute("errSur", "Campo obbligatorio");
			tuttoOk = false;
		} else
			supplier.setSurname(surname);
		return tuttoOk;
	}

}
