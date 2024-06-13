package org.example;

import org.example.database.entity.Customer;

public class EqualsDemo {

    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setId(1);
        c1.setCustomerName("abc");
        c1.setContactFirstname("XYZ");

        Customer c2 = new Customer();
        c2.setId(1);
        c2.setCustomerName("abc");
        c2.setContactFirstname("!@#");

        // this will be 2 variables pointing to the same memory location
        Customer c3 = c1;
        if ( c1 == c3 ) {
            // this is true because both variables are pointing to the same
            // memory location
        }

        if ( c1 == c2 ) {
            // this is only comparing the memory locations
            // this is the default implementation of the .equals method
        }

        if ( c1.equals(c2) ) {
            System.out.println("The 2 customers are equals");
        } else {
            System.out.println("The customers are not equal");
        }

    }

}
