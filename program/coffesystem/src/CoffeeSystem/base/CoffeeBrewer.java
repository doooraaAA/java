package CoffeeSystem.base;

public class CoffeeBrewer extends Product {
	private final String model;
	private final String waterType;
	private final int numberOfCups;
	public CoffeeBrewer(String code,String description,double price,String model,String waterType,int numberOfCups) {
		super(code,description,price);
		this.model = model;
		this.waterType = waterType;
		this.numberOfCups = numberOfCups;
	}
	public String getModel() {
		return this.model;
	}
	public String getWaterType() {
		return this.waterType;
	}
	public int getNumberOfCups() {
		return this.numberOfCups;
	}
	public String toString() {
		 return super.toString()+"_"+getModel()+"_"+getWaterType()+"_"+getNumberOfCups();
	}

}
