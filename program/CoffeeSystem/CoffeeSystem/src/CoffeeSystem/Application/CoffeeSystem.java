package CoffeeSystem.Application;
import CoffeeSystem.base.*;
import java.util.*;
public class CoffeeSystem {
	private  Catalog catalog;

	private Order currentOrder;
	private  Sales sales;
	
	Scanner in=new Scanner(System.in);
	
	public static void main(String[] args) {
		CoffeeSystem coffee = new CoffeeSystem();
		coffee.run();
	}
	//构造函数
	private CoffeeSystem() {
		this.catalog = loadCatalog();
		this.sales = loadSales(this.catalog);
		this.currentOrder = new Order();

	}
//设定商品信息
	private Catalog loadCatalog() {
		Catalog catalog = new Catalog();
		catalog.upgradeAProduct(new Coffee("C001","Colombia,whole,1 1b",17.99,"Colombia","Medium","Rich and Hearty","Rich","Medium","Full"));
		catalog.upgradeAProduct(new Coffee("C002","Colombia,Ground,1 1b",18.75,"Colombia","Medium","Rich and Hearty","Rich","Medium","Full"));
		catalog.upgradeAProduct(new Coffee("C007","Guatemala,whole,1 1b",17.99,"Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full"));
		catalog.upgradeAProduct(new Coffee("C008","Guatemala,Ground,1 1b",18.75,"Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full"));
		catalog.upgradeAProduct(new CoffeeBrewer("B001","Home Coffee Brewer",150.00,"Brewer 100","Pourover",6));
		catalog.upgradeAProduct(new CoffeeBrewer("B002","Coffee Brewer,2 Warmers",200.00,"Brewer 200","Pourover",12));
		catalog.upgradeAProduct(new CoffeeBrewer("B003","Coffee Brewer,3 Warmers",280.00,"Brewer 210","Pourover",12));
		catalog.upgradeAProduct(new CoffeeBrewer("B004","Commercial Brewer,20 cups",380.00,"Quick Coffee 100","Automatic",20));
		catalog.upgradeAProduct(new CoffeeBrewer("B005","Commercial Brewer,40 cups",480.00,"Quick Coffee 200","Automatic",40));
		catalog.upgradeAProduct(new Product("A001","Almond Flavored Syrup",9.00));
		catalog.upgradeAProduct(new Product("A002","Irish Creme Flavored Syrup",9.00));
		catalog.upgradeAProduct(new Product("A005","Gourmet Coffee Cookies",12.00));
		catalog.upgradeAProduct(new Product("A007","Gourmet Coffee Ceramic Mug",8.00));
		catalog.upgradeAProduct(new Product("A009","Gourmet Coffee 36 Cup Filters",45.00));
	
		return catalog;
		
	}
	//存入订单
	private Sales loadSales(Catalog catalog) {
		Sales sales = new Sales();
		Order[] orders =new Order[6];//设定6个
		
		orders[0]=new Order();
		orders[0].addAProduct(new OrderProduct(catalog.getProduct("C001"),5));
		sales.addAnOrder(orders[0]);
		
		orders[1] = new Order();
		orders[1].addAProduct(new OrderProduct(catalog.getProduct("C002"),2));
		orders[1].addAProduct(new OrderProduct(catalog.getProduct("A001"),2));
		orders[1].addAProduct(new OrderProduct(catalog.getProduct("A005"),2));
		sales.addAnOrder(orders[1]);
		
		orders[2] = new Order();
		orders[2].addAProduct(new OrderProduct(catalog.getProduct("B002"),1));
		orders[2].addAProduct(new OrderProduct(catalog.getProduct("A005"),3));
		sales.addAnOrder(orders[2]);
		
		orders[3] = new Order();
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("B003"),2));
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("C001"),3));
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("C007"),3));
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("C008"),3));
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("A001"),3));
		orders[3].addAProduct(new OrderProduct(catalog.getProduct("A007"),2));
		sales.addAnOrder(orders[3]);
		
		orders[4] = new Order();
		orders[4].addAProduct(new OrderProduct(catalog.getProduct("B001"),1));
		orders[4].addAProduct(new OrderProduct(catalog.getProduct("C002"),2));
		orders[4].addAProduct(new OrderProduct(catalog.getProduct("C007"),2));
		sales.addAnOrder(orders[4]);
		
		orders[5] = new Order();
		orders[5].addAProduct(new OrderProduct(catalog.getProduct("B001"),1));
		orders[5].addAProduct(new OrderProduct(catalog.getProduct("C002"),3));
		sales.addAnOrder(orders[5]);
		return sales;
	}
	//打印菜单
	public void displayCatalog() {
		int size =this.catalog.getNumberOfProducts();
		
		if(size==0) {
			System.out.println("The catalog is empty");
		}
		else {
			for(Product product:this.catalog) {
				System.out.println(product.getCode()+" "+product.getDescription());
			}
		}
	}
	//读入商品
		private Product readProduct() {
			do {
				System.out.println("Product code: ");
				String n = in.next();
				Product product = this.catalog.getProduct(n);
				if(product != null) {
					return product;
				}
				else {
					System.out.println("There are no products with the code.");
				}
			}while(true);
		}
//打印商品信息
	public void displayProduct() {
		Product product = readProduct();
		System.out.println("Description: "+product.getDescription());
		System.out.println("Price: "+product.getPrice());
		if(product instanceof Coffee) {
			Coffee coffee =(Coffee) product;
			System.out.println("Origin: "+coffee.getOrigin());
			System.out.println("Roast: "+coffee.getRoast());
			System.out.println("Flavor: "+coffee.getFlavor());
			System.out.println("Aroma: "+coffee.getAroma());
			System.out.println("Acidity: "+coffee.getAcidity());
			System.out.println("Body: "+coffee.getBody());
		}
		else if (product instanceof CoffeeBrewer) {
			CoffeeBrewer brewer = (CoffeeBrewer)product;
			System.out.println("Model: "+brewer.getModel());
			System.out.println("Water Type: "+brewer.getWaterType());
			System.out.println("NumberOfcups: "+brewer.getNumberOfCups());
			
		}
	}
//打印当前订单
	public void displayCurrentOrder() {
		int size=this.currentOrder.getNumberOfItems();
		if(size ==0) {
			System.out.println("The current order is empty.");
		}
		else {
			for(OrderProduct orderProduct:this.currentOrder) {
				System.out.println(orderProduct.toString());
			}
			System.out.println("Total: "+this.currentOrder.getTotalMoney()+"RMB");
		}
	}
	//读入数量
		private int readQuantity() {
			int quantity;
			do {
				System.out.print("Quantity> ");
				quantity=in.nextInt();
				if(quantity>0) {
					return quantity;
				}else {
					System.out.println("Invalid input.Please enter a positive integer.");
				}
			}while(true);
		}
//添加商品
	public void addProductOrder() {
		Product product=readProduct();
		int quantity=readQuantity();
		OrderProduct orderProduct=this.currentOrder.getProduct(product);
		
		if(orderProduct == null) {
			this.currentOrder.addAProduct(new OrderProduct(product,quantity));
			System.out.println("The quantity of the product "+product.getCode()+"has been added");
		}else {
			orderProduct.setQuantity(quantity);
			System.out.println("The quantity of the product "+product.getCode()+"has been modified");
		}
	}

//删除商品
	public void removeProductOrder() {
		Product product =readProduct();
		OrderProduct orderProduct=this.currentOrder.getProduct(product);
		if(orderProduct!=null) {
			this.currentOrder.removeAProduct(orderProduct);
			System.out.println("The product "+product.getCode()+"has been removed from the current order");
			
		}else {
			System.out.println("There are no products in the current order with that code");
		}
	}
//结算订单
	public void registerCurrentOrder() {
		if(this.currentOrder.getNumberOfItems()>0) {
			this.sales.addAnOrder(this.currentOrder);
			this.currentOrder=new Order();
			System.out.println("The sale of the order has been registered");
		}else {
			System.out.println("The current order is empty");
		}
	}
//打印已售订单
	public void displayOrder() {
		int numOrders=this.sales.getNumberOfOrders();
		if(numOrders!=0) {
			int orderNumber = 1;
			for(Order order:this.sales) {
				System.out.println("Order"+orderNumber++);
				for(OrderProduct orderProduct :order) {
					System.out.println("  "+orderProduct.toString());
				}
				System.out.println("  Total: "+order.getTotalMoney()+"RMB");
			}
		}
		else {
			System.out.println("There are no sales.");
		}
	}
//打印某个产品被购买的数量
	public void displayNumberOfOrders(Product product){
		int numberOfOrdersWithProduct=0;
		for(Order order :this.sales){
			for(OrderProduct orderProduct:order){
				if(orderProduct.getProduct().equals(product)){
					numberOfOrdersWithProduct++;
				}
			}
		}
		System.out.println("Number of orders that contains the product"+product.getCode()+":"+numberOfOrdersWithProduct);
	}
//打印所有产品被购买数量
	public void displayTotalQuantityOfProducts(){
		for(Product productInCatalog :this.catalog){
			int quantityOfProduct = 0;
			for(Order order:this.sales){
				for(OrderProduct orderProduct :order){
					if (orderProduct.getProduct().equals(productInCatalog)) {
						quantityOfProduct+=orderProduct.getQuantity();
					}
				}
			}
			System.out.println(productInCatalog.getCode()+" "+quantityOfProduct);

		}
	}
//运行系统
	private void run() {
		int choice=getChoice();
		while(choice!=0) {
			if(choice==1) {
			displayCatalog();//打印菜单
			}else if(choice==2) {
				displayProduct();//打印商品信息
			}else if(choice==3) {
				displayCurrentOrder();//打印当前订单
			}else if(choice==4) {
				addProductOrder();//添加商品
			}else if(choice==5) {
				removeProductOrder();//删除商品
			}else if(choice==6){
				registerCurrentOrder();//结算订单
			}else if(choice==7) {
				displayOrder();//打印已售订单
			}else if(choice==8){
				displayNumberOfOrders(readProduct());//打印某一订单的数量
			}else if(choice==9){
				displayTotalQuantityOfProducts();//打印所有产品的购买数量
			}
			choice=getChoice();
		}
	}
//用户输入
	private int getChoice() {
		int input;
		do {
			System.out.print("[0] Quit\n"+
		                     "[1] Display catalog\n"+
					         "[2] Display product\n"+
		                     "[3] Display current order\n"+
					         "[4] Add product to current order\n"+
		                     "[5] Remove product from current order\n"+
					         "[6] Register sale of current order\n"+
		                     "[7] Display sales\n"+
					         "[8] Display number of orders\n"+
					         "[9] Display total quantity of products\n"+
					         "choice> ");
			input = in.nextInt();
			if(input==0) {
				System.out.println("已退出，欢迎下次光临！");

			}
			if(0<=input&&9>=input) {
				break;
			}else {
				System.out.println("输入错误！");
			}
		}while(true);
		return input;
	}
}

