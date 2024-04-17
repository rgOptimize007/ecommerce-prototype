/*
package com.ecommerce.repositories;

import com.ecommerce.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CommandLineRunner {


    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger log = LoggerFactory.getLogger(CustomerRepository.class);

    @Override
    public void run(String... args) throws Exception {

        //drop table if exists
        log.info("Dropping table: customers");
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");

        // Create a table
        log.info("Creating table: customers");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255) , last_name VARCHAR(255))");


        log.info("Table created");

        //insert some data
        log.info("Inserting data");
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES('John','Doe')",
                "INSERT INTO customers(first_name,last_name) VALUES('Jane','Doe')",
                "INSERT INTO customers(first_name,last_name) VALUES('Jack','Doe')");

        // Querying
        log.info("Querying for customer records:");
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
                        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")), "John")
                .forEach(customer -> log.info(customer.toString()));

    }
}
*/
