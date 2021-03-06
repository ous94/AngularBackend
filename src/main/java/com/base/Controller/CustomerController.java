/*package com.base.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.Repository.UserRepository;
import com.base.entities.Personne;

@RestController
@RequestMapping("/api")
public class UserController {
	//l'interface de repository
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Personne> getUser()
	{
		 return repository.findAll();
	}
	// recuperation par ID
	@GetMapping("/user/{id}")
	public Optional<Personne> getUserid(@PathVariable long id)
	{
		 return repository.findById(id);
	}
	//suppression par id
	@DeleteMapping("/user/{id}")
	public Boolean deleteUserid(@PathVariable long id)
	{
		repository.deleteById(id);
		return true;
	}
	// Enregistrement de nouveau user
	@PostMapping("user")
	public Personne createUser(Personne user)
	{
		return repository.save(user);
	}
	//editer un user
	@PutMapping("user")
	public Personne updateUser(Personne user)
	{
		return repository.save(user);
	}

}*/
package com.base.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.base.Model.Customer;
import com.base.Repository.CustomerRepository;
 
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CustomerController {
 
	@Autowired
	CustomerRepository repository;
	
	@GetMapping("/api")
 public String hi()
 {
	 return "bienvenue Demarage en cour ...";
 }
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Customers...");
 
		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);
 
		return customers;
	}
	
	@GetMapping(value = "customers/{id}")
	public Optional<Customer> findByid(@PathVariable Long id) {
		System.out.println("Get one Customer...");
 
		return repository.findById(id);
	}
 
	@PostMapping(value = "/customers/create")
	public Customer postCustomer(@RequestBody Customer customer) {
		System.out.println("Ajout d'un Customers...");
 
		Customer _customer = 
				repository.save(new Customer(customer.getId(),customer.getName(), customer.getAge(),customer.isActive()));
		return _customer;
	}
 
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	
	
 
	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}
 
	@GetMapping(value = "customers/age/{age}")
	public List<Customer> findByAge(@PathVariable int age) {
		System.out.println("recherche Customer de l'age"+age);

 
		List<Customer> customers = repository.findByAge(age);
		return customers;
	}
 
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");
 
		Optional<Customer> customerData = repository.findById(id);
 
		    Customer _customer = customerData.get();
			_customer.setId(customer.getId());
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		
	}
	//la methode ajouter
	@PutMapping("/custumeredit")
	public List<Customer> updatemaCustomer( @RequestBody Customer customer) throws Exception {
		System.out.println("Update Customer with ID = " + customer.getId() + "...");
 
		Optional<Customer> customerData = repository.findById(customer.getId());
           
		    /*Customer _customer = customerData.get();
			_customer.setId(customer.getId());
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);*/
		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setId(customer.getId());
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			repository.save(_customer);
			
			return getAllCustomers();
		} else {
			return null;
		}
		
	}
}
