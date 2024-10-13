package CoffeeSystem.base;
import java.util.ArrayList;
import java.util.Iterator;
public class Catalog implements Iterable<Product>{

	private final ArrayList<Product>products;
	public Catalog() {
		this.products = new ArrayList<Product>();
	}
	public Iterator<Product>iterator(){
		return this.products.iterator();
	}
	public void upgradeAProduct(Product product) {
		this.products.add(product);
	}

	public Product getProduct(String code) {
		for(Product product:this.products) {
			if(product.getCode().equals(code)) {
				return product;
			}
		}
		return null;
	}
	//根据code找到相应的产品
	public int getNumberOfProducts() {
		return this.products.size();
	}
    //返回products的数量
}
