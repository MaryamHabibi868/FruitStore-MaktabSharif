package ir.maktabquizw21.service;

import ir.maktabquizw21.domains.Customer;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ManagerServiceImplTest {

    private CustomerService customerService;
    private ManagerService customer;


    @Test
    public void printAllCustomers_shouldReturnAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setUserName("user1");
        Customer customer2 = new Customer();
        customer2.setUserName("user2");

        List<Customer> expectedList = Arrays.asList(customer1, customer2);
        when(customerService.findAll()).thenReturn(expectedList);

        List<Customer> result = customer.printAllCustomers();

        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getUserName());
        assertEquals("user2", result.get(1).getUserName());
        verify(customerService).findAll();
    }
}