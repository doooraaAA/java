package CoffeeSystem.base;
import java.util.ArrayList;
import java.util.Iterator;
public class Sales implements  Iterable<Order>{
	private final ArrayList<Order> orders;
	public Sales() {
		this.orders=new ArrayList<Order>();
	}
	public void addAnOrder(Order order) {
		this.orders.add(order);
	}
	public Iterator<Order> iterator(){
		return this.orders.iterator();
	}
	public int getNumberOfOrders() {
		return this.orders.size();
	}
	
      
}
