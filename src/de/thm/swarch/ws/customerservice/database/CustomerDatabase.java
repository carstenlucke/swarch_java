package de.thm.swarch.ws.customerservice.database;


import de.thm.swarch.ws.customerservice.dao.Customer;
import de.thm.swarch.ws.customerservice.dao.Gender;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {


    public static List<Customer> getAllCustomers() {
        List<Customer> data = new ArrayList<>();
        data.add(new Customer(
                "Max",
                "Mustermann",
                "mm@web.de",
                Gender.MALE,
                "156.45.22.145"));

        data.add(new Customer(
                "John",
                "Doe",
                "john@doe.com",
                Gender.MALE,
                "226.4.12.14"));

        data.add(new Customer(
                "Jane",
                "Doe",
                "jane@doe.com",
                Gender.FEMALE,
                "226.4.12.14"));

        data.add(new Customer(
                "Frieda",
                "Franzen",
                "frieda@danger.net",
                Gender.FEMALE,
                "8.8.8.8"));

        return data;
    }
}
