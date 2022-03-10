package co.greatlearning.springmvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import co.greatlearning.springmvc.dao.CustomerDao;
import co.greatlearning.springmvc.entity.Customer;

@Controller
public class CustomerController {

	@Autowired 
	@Qualifier("customervalidator")
	private Validator customervalidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(customervalidator);
	}
	
	@Autowired
	private CustomerDao daocust;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		List<Customer> customers=daocust.getAllCustomers();
		model.addAttribute("message", "Welcome Home");
		model.addAttribute("customers", customers);
		return "main-menu";
	}
	/*
	 * @RequestMapping("/test") public String mainMenu(Model model) { //Customer
	 * customer= new Customer(); //model.addAttribute("customers",
	 * Arrays.asList(customer));
	 * 
	 * List<Customer> customers=daocust.getAllCustomers();
	 * model.addAttribute("message", ""); model.addAttribute("customers",
	 * customers); //return "test"; return "main-menu"; }
	 */
	
	@RequestMapping("/addPage")
	public String showForm(Model model) {
		Customer customer= new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("message", "New Customer Registration");
		return "show-form-new";
	}
	
	@RequestMapping(path = "/updatePage/{id}")
	public String showupdateForm(Model model,@PathVariable("id") Integer id) {
		Customer customerToBeUpdated = daocust.getCustomer(id);
		model.addAttribute("customer", customerToBeUpdated);
		model.addAttribute("message", "Update Details for Customer " + customerToBeUpdated.getFirstName() + " " + customerToBeUpdated.getLastName());
		return "show-form-update";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Model model,@ModelAttribute("customer") @Validated Customer customer ,BindingResult binding) {
		if (binding.hasErrors()) {
			return "show-form-new";
		}
		String message=daocust.addCustomer(customer);
		List<Customer> customers=daocust.getAllCustomers();
		model.addAttribute("message", message);
		model.addAttribute("customers", customers);
		return "main-menu";
	}
	
	@RequestMapping(path = "/updateCustomer")
	public String updateCustomer(Model model,@ModelAttribute("customer") @Validated Customer customer ,BindingResult binding) {
		if (binding.hasErrors()) {
			return "show-form-update";
		}
		System.out.println(" updateCustomer" + customer.toString());
		String message=daocust.updateCustomer(customer);
		List<Customer> customers=daocust.getAllCustomers();
		model.addAttribute("message", message);
		model.addAttribute("customers", customers);
		return "main-menu";
	}
	
	@RequestMapping(path = "/deleteCustomer/{id}")
	public String deleteCustomer(Model model,@PathVariable("id") Integer id) {
		System.out.println(" deleteCustomer" + id.toString());
		String message=daocust.deleteCustomer(id);
		List<Customer> customers=daocust.getAllCustomers();
		model.addAttribute("message", message);
		model.addAttribute("customers", customers);
		return "main-menu";
	}
}
