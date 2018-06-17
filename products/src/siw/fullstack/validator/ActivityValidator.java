package siw.fullstack.validator;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import siw.fullstack.model.Activity;
import siw.fullstack.model.Student;

public class ActivityValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String name = request.getParameter("name");
		String nome ="";
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		ArrayList<Student> suppliers = new ArrayList<Student>();
		Activity product = (Activity)request.getAttribute("product");
		
		product.setSuppliers(suppliers);
		
		if(name == null || name.equals("")) {
			request.setAttribute("errName", "Campo obbligatorio");
			tuttoOk = false;
		} else
			nome = name.substring(0, 1).toUpperCase() + name.substring(1,name.length());
			product.setName(nome);
		
		if(day == null || day.equals("")) {
			request.setAttribute("errDay", "Campo obbligatorio");
			tuttoOk = false;
		} else
			product.setDay(day);
		
		if(time == null || time.equals("")) {
			request.setAttribute("errTime", "Campo obbligatorio");
			tuttoOk = false;
		} else 
			product.setTime(time);
		
		return tuttoOk;
	}
}