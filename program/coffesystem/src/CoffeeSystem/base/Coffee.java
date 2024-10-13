package CoffeeSystem.base;

public class Coffee extends Product {
   private String origin;
   private String roast;
   private String flavor;
   private String aroma;
   private String acidity;
   private String body;
   public Coffee(String code,String description,double price,String origin,String roast,String flavor,String aroma,
		   String acidity,String body) {
   super(code,description,price);
   this.origin = origin;
   this.roast = roast;
   this.flavor = flavor;
   this.aroma = aroma;
   this.acidity = acidity;
   this.body = body;
   }
   public String getOrigin() {
	   return this.origin;
   }
   public String getRoast() {
	   return this.roast;
   }
   public String getFlavor() {
	   return this.flavor;
   }
   public String getAroma() {
	   return this.aroma;
   }
   public String getAcidity() {
	   return this.acidity;
   }
   public String getBody() {
	   return this.body;
   }
   public String toString() {
	   return super.toString()+"_"+getOrigin()+"_"+getRoast()+"_"+getFlavor()+"_"+getAroma()+"_"+getAcidity()+"_"+getBody();
   }
}
