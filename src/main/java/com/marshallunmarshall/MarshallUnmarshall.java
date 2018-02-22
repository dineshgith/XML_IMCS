package com.marshallunmarshall;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.customer.Address;
import com.customer.Customer;
import com.customer.PaymentMethod;

public class MarshallUnmarshall {
	public void marshall() {
		try {
			// creating the JAXB context
			JAXBContext jContext = JAXBContext.newInstance(com.customer.Customer.class);
			// creating the marshaller object
			Marshaller marshallObj = jContext.createMarshaller();
			// setting the property to show xml format output
			marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// setting the values in POJO class

			Address address = new Address();
			address.setCity("irving");
			address.setHouseNo(5411);
			address.setState("TX");
			address.setStreet("Auther");
			address.setZipCode(5678);

			Customer customer = new Customer();
			customer.setAnnualSalary(69999);
			customer.setCustomerId(121);
			customer.setCustomerName("micheal");
			customer.setDateOfBirth("2-18-2018");

			PaymentMethod paymentmethod = new PaymentMethod();
			paymentmethod.setCardName("micheal");
			paymentmethod.setCardNo(57999827);
			paymentmethod.setDateFrom("2-18-2014");
			paymentmethod.setDateTo("2-18-2018");

			// calling the marshall method
			marshallObj.marshal(customer, new FileOutputStream(
					"C:\\Users\\DINESH\\eclipse-workspace\\xml\\src\\main\\resources\\customermarshall.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void unMarshall() {

		try {
			// creating the JAXB context
			JAXBContext jContext = JAXBContext.newInstance(Customer.class);
			// creating the marshaller object
			Unmarshaller unmarshallObj = jContext.createUnmarshaller();
			// calling the unmarshall method
			Customer customer = (Customer) unmarshallObj.unmarshal(
					new File("C:\\Users\\DINESH\\eclipse-workspace\\xml\\src\\main\\resources\\customermarshall.xml"));
			System.out.println(customer.getCustomerName() + "  " + customer.getCustomerId() + "   "
					+ customer.getAnnualSalary() + "  " + customer.getDateOfBirth());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
