package ir.maktabquizw21.service;

import ir.maktabquizw21.CustomExeption.CustomException;
import ir.maktabquizw21.config.ApplicationContext;
import ir.maktabquizw21.domains.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CustomerServiceImplTest {

    @Test
    public void testRegisterCustomer() {
        ApplicationContext instance = ApplicationContext.getInstance();

        CustomerService customerService = instance.getCustomerService();
        Assertions.assertEquals(0, customerService.findById(100L));

        Customer customer = new Customer();
        Assertions.assertThrows(
                CustomException.class , () -> customerService.save(customer)
        );

        customer.setName("Test");
        customerService.save(customer);

        Assertions.assertNotNull(customer);

    }
}