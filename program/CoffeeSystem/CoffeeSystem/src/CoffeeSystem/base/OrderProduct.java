package CoffeeSystem.base;

public class OrderProduct {
	private final Product product;
	private int quantity;
	public OrderProduct(Product initProduct,int initQuantity) {
		this.product = initProduct;
		this.quantity = initQuantity;
	}
	public Product getProduct() {
		return this.product;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}//设置新的数量
    
	public double getMoney() {
		return getProduct().getPrice()*(double)getQuantity();
	}
	public String toString() {
		return getQuantity()+" "+getProduct().getCode()+" "+getProduct().getPrice();
	}
}
