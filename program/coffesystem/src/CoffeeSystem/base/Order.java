package CoffeeSystem.base;
import java.util.ArrayList;
import java.util.Iterator;
public class Order implements Iterable<OrderProduct> {
	private final ArrayList<OrderProduct> items;

	public Order() {
		this.items=new ArrayList<OrderProduct>();
	}
	public void addAProduct(OrderProduct orderProduct) {
		this.items.add(orderProduct);
	}
	public void removeAProduct(OrderProduct orderProduct) {
		this.items.remove(orderProduct);
	}
public Iterator<OrderProduct>iterator(){
		return this.items.iterator();
}


	public OrderProduct getProduct(Product product) {
		for(OrderProduct orderProduct:this.items) {
			if(orderProduct.getProduct().equals(product)) {
				return orderProduct;
			}
		}
		return null;
	}
	public int getNumberOfItems() {
		return this.items.size();
	}
	public double getTotalMoney() {
		double total=0.0 ;
		for(OrderProduct orderProduct:this.items) {
			total+=orderProduct.getMoney();
		}
		return total;
	}

}
