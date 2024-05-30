package com.metrics.metric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import com.metrics.metric.configuration.DBConnection;
import com.metrics.metric.entities.customer.Customer;
import com.metrics.metric.services.CustomerService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class CustomerServiceTests {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );
    CustomerService customerService;
    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        DBConnection connectionProvider = new DBConnection(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        customerService = new CustomerService(connectionProvider);
    }

    @Test
    void shouldGetCustomers() {
        customerService.createCustomer(new Customer(1L, "George"));
        customerService.createCustomer(new Customer(2L, "John"));

        List<Customer> customers = customerService.getAllCustomers();
        assertEquals(2, customers.size());
    }
}
