package device;

import java.util.*;

public class Electronics {
	
	
	//basic nature
	public double weight;
	public double price;
	public String name;
	public String manufacturer;
	public int powerConsumption;
	
	Scanner scan=new Scanner(System.in);

	//Input functions are as follows
	public void getName() {
		String name=scan.nextLine();
		this.name=name;
	}
	public void getManufacturer() {
		Scanner scans=new Scanner(System.in);
		String manufacturer=scans.nextLine();
		this.manufacturer=manufacturer;
	}
	public void getWeight() {
		double weight=scan.nextDouble();
		this.weight=weight;
	}
	public void getprice() {
		double price=scan.nextDouble();
		this.price=price;
	}
	public void getPowerConsumption() {
		int powerConsumption=scan.nextInt();
		this.powerConsumption=powerConsumption;
	}
	
	//Output functions are as follows
	public void printName() {
		System.out.println("Name: "+this.name);
		System.out.println("Manufacturer: "+this.manufacturer);
		System.out.println("Weight: "+this.weight);
		System.out.println("Price: "+this.price);
		System.out.println("PowerConsumption: "+this.powerConsumption);
	}
	
	//Other functions are as follows
	public String toString() {
		return weight + "-" + price + "-" + manufacturer + "-" + powerConsumption;
	}
}