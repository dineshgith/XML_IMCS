package com.jsonmapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.customer.Customer;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper {

	private static String FILE_PATH = "C:\\Users\\DINESH\\eclipse-workspace\\xml\\src\\main\\resources\\customerjson.json";

	public static void main(String[] args) throws IOException {
		//serialize();
		 deserialize();
	}

	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// convert Object to json string
		Customer customer = createCustomer();

		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// writing to console, can write to any output stream such as file
		objectMapper.writeValue(System.out, customer);
		objectMapper.writeValue(new PrintWriter(FILE_PATH), customer);
	}

	public static void deserialize() throws IOException {

		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		Customer customer = objectMapper.readValue(jsonData, Customer.class);

		System.out.println("Customer Object\n" + customer);
	}

	private static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(121);
		customer.setCustomerName("micheal");
		customer.setAnnualSalary(69999);
		customer.setDateOfBirth("2-18-2018");
		return customer;
	}

}
