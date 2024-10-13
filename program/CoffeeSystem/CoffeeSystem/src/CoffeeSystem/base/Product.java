package CoffeeSystem.base;

public class Product {
	private final String code;
	private final String description;
	private final double price;
	public Product(String code,String description,double price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}
	public String getCode() {
		return this.code;
	}
	public String getDescription() {
		return this.description;
	}
	public double getPrice() {
		return this.price;
	}
	public boolean equals(Object object) {
		return object instanceof Product &&getCode().equals(((Product)object).getCode());
	}
	//equals语句，判断为product类，输入编码是否和你想要的编码相同，相同返回
	public String toString() {
		return getCode()+"_"+getDescription()+"_"+getPrice();
	}

	
}
