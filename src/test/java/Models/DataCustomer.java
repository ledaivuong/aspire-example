package Models;

public class DataCustomer {
	private String id;

	private Customer data;

	public String getId() {
		return id;
	}

	public Customer getCustomer() {
		return data;
	}

	public DataCustomer(String id, Customer data) {
		this.id = id;
		this.data = data;
	}

}
