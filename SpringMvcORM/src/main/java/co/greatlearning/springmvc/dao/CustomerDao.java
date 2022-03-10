package co.greatlearning.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import co.greatlearning.springmvc.entity.Customer;

public class CustomerDao {

	public CustomerDao() {
		super();
	}
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}
	
	@Transactional(readOnly = false)
	public List<Customer> getAllCustomers() {
		List<Customer> customers= hibernatetemplate.loadAll(Customer.class);
		return customers;
	}

	@Transactional(readOnly = false)
	public Customer getCustomer(Integer id) {
		Customer customer= hibernatetemplate.get(Customer.class,id);
		return customer;
	}

	@Transactional(readOnly = false)
	public String addCustomer(Customer customerNew) {
		String result ="";
		System.out.println("******Add New Customer*******");
		hibernatetemplate.save(customerNew);
		result="New Customer " + customerNew.getFirstName() + " added successfully";
		return result;
	}

	@Transactional(readOnly = false)
	public String updateCustomer(Customer customerUpdate) {
		String result ="";
		System.out.println("******Update Customer*******");
		Customer customer=getCustomer(customerUpdate.getId());
		System.out.println("Cutomer Details " + customer);
		if (customer != null) {
			customer.setFirstName(customerUpdate.getFirstName());
			customer.setLastName(customerUpdate.getLastName());
			customer.setEmail(customerUpdate.getEmail());
			hibernatetemplate.update(customer);
			result="Existing Customer " + customer.getFirstName() + " details updated successfully";
			System.out.println("Cutomer Details updated " + customerUpdate);
		}else {
			result="Customer not Found";
		}
		System.out.println(result);
		return result;
	}

	@Transactional(readOnly = false)
	public String deleteCustomer(Integer id) {
		String result ="";
		System.out.println("******Delete Customer*******");
		Customer customer=getCustomer(id);
		if (customer != null) {
			hibernatetemplate.delete(customer);
			result="Existing Customer " + customer.getFirstName() + " deleted successfully";
		}else {
			result="Customer not Found";
		}
		System.out.println(result);
		return result;
	}
}
