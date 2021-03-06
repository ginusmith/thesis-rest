package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Customer;
import hu.unideb.thesis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("findAll")
    public ResponseEntity<List<Customer>> getAll() {

        List<Customer> list = customerService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        Customer addedCust = customerService.add(customer.getFirstName(), customer.getLastName());

        return new ResponseEntity<>(addedCust, HttpStatus.OK);
    }

    @DeleteMapping("deleteCust")
    public ResponseEntity<Void> deleteCust(@RequestBody Customer customer) {
        customerService.deleteCust(customer.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
