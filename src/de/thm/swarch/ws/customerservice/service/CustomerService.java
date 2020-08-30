package de.thm.swarch.ws.customerservice.service;


import de.thm.swarch.ws.customerservice.dao.Customer;
import de.thm.swarch.ws.customerservice.database.CustomerDatabase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public class CustomerService {

    @WebMethod
    public List<Customer> getCustomers() {
        return CustomerDatabase.getAllCustomers();
    }
}
