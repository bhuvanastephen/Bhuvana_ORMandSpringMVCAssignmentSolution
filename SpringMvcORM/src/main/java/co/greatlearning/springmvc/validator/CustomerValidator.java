package co.greatlearning.springmvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.greatlearning.springmvc.dao.CustomerDao;
import co.greatlearning.springmvc.entity.Customer;

public class CustomerValidator implements Validator {

//	@Autowired
//	private CustomerDao dao;

	@Override
	public boolean supports(Class<?> obj) {
		// TODO Auto-generated method stub
		//return Users.class.isAssignableFrom(obj);
		return true;
	}

	@Override
	public void validate(Object arg0, Errors err) {
		System.out.println(" inside user validator");
		Customer customer = (Customer) arg0;
		if (customer.getFirstName().length() == 0) {
			err.rejectValue("firstName", "ERROR.EMPTY", "Firstname is Empty");
		} else if (customer.getLastName().length() == 0) {
			err.rejectValue("lastName", "ERROR.EMPTY", "Lastname is Empty");
		} else if (customer.getEmail().length() == 0) {
			err.rejectValue("email", "ERROR.EMPTY", "Email is Empty");
		} else if (customer.getEmail().contains("@") == false) {
			err.rejectValue("email", "ERROR.EMPTY", "Email is incorrect");
		} 
//		else {
//			Boolean validationresult = dao.findCustomer(customer);
//			if (validationresult) {
//				err.rejectValue("firstName", "ERROR.INVALID", "User Already present");
//			} 

		}
	}


