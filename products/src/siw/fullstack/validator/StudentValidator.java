package siw.fullstack.validator;



import javax.servlet.http.HttpServletRequest;

import siw.fullstack.model.Student;

public class StudentValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String name = request.getParameter("name");
		String nome ="";
		String cognome = "";
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String place = request.getParameter("birthplace");
		String date = request.getParameter("dateofbirth");
		Student supplier = (Student)request.getAttribute("supplier");
		
		if(name == null || name.equals("")) {
			request.setAttribute("errName", "Campo obbligatorio");
			tuttoOk = false;
		} else
			nome = name.substring(0, 1).toUpperCase() + name.substring(1,name.length());
			supplier.setName(nome);
		
		if(surname == null || surname.equals("")) {
			request.setAttribute("errSur", "Campo obbligatorio");
			tuttoOk = false;
		} else
			cognome = surname.substring(0, 1).toUpperCase() + surname.substring(1,surname.length());
			supplier.setSurname(cognome);
		
		if(email == null || email.equals("")) {
			request.setAttribute("errMail", "Campo obbligatorio");
			tuttoOk = false;
		} else
			supplier.setEmail(email);
		
		if(telephone == null || telephone.equals("")) {
			request.setAttribute("errTel", "Campo obbligatorio");
			tuttoOk = false;
		} else
				supplier.setTelephone(telephone);
		
		if(place == null || place.equals("")) {
			request.setAttribute("errBpl", "Campo obbligatorio");
			tuttoOk = false;
		} else
			supplier.setBirthplace(place);
		
		if(date == null || date.equals("")) {
			request.setAttribute("errDob", "Campo obbligatorio");
			tuttoOk = false;
		} else
		    supplier.setDateofbirth(date);
		
		return tuttoOk;
	}

}
