package de.thm.swarch.ws.customerservice.service;


import de.thm.swarch.ws.customerservice.dao.Customer;
import de.thm.swarch.ws.customerservice.database.CustomerDatabase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


// TODO: Als WS annotieren
public class CustomerService {

    // TODO: Als WS-Methode annotieren
    public List<Customer> getCustomers() {
        // TODO Rückgabe der Kundenobjekte impl.
        return null;
    }
}
