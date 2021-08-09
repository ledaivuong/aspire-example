package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

import Models.Customer;
import Models.DataCustomer;

public class JsonHandler {

	public static Customer getJsonDataCustomer(String customerId) throws FileNotFoundException {
		Customer resultCustomer = null;
		File file = new File("./src/test/java/Data/customer.json");
		Reader reader = new FileReader(file);
		Gson gson = new Gson();
		DataCustomer[] customers = gson.fromJson(reader, DataCustomer[].class);
		for (DataCustomer customer : customers) {
			if (customer.getId().equals(customerId)) {
				resultCustomer = customer.getCustomer();
			}
		}
		return resultCustomer;
	}
}
