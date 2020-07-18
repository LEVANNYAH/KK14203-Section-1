/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   LECTURER: DR MOHD SHAMRIE SAININ
   LAB 5 EXERCISE 3
*/

abstract class Cake{
    String name;
    String[] topping;
    String[] toppingOrder;
    double priceSmall;
    double priceMedium;
    double priceBig;
    double totalPrice;
    int size;
    int quantity;
   
   Cake(String name){
      this.name = name;
   }
   
   abstract public void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig);
   
   public void orderCake(String[] tO, int q, int s){
       toppingOrder = tO;
       quantity = q;
       size = s;
   }
   
   public double getSizePrice(){
       double sizePrice = 0.0;
       if(size == 1){
          sizePrice = priceSmall;
       }else if(size == 2){
          sizePrice = priceMedium;
       }else if(size == 3){
          sizePrice = priceBig;
       }
       return sizePrice;
   }
   
    public double getTotalPrice(){
       totalPrice = getSizePrice() * quantity + (toppingOrder.length*10);
       return totalPrice;
   }

   public String getSize(){
       String cakeSize = " ";
       if(size == 1){
         cakeSize = "Small";
       }else if(size == 2){
         cakeSize = "Medium";
       }else if(size == 3){
         cakeSize = "Big";
       }
       return cakeSize;
   }
   
   public void printCake(){
       System.out.println("-----------------------------");
       System.out.println("\t\t\tCake Menu");
       System.out.println("-----------------------------");
       System.out.println(name + " with available toppings:");
       for(int i = 0; i < topping.length; i++){
          System.out.println((i+1) + ") " + topping[i]);
      }
      System.out.print("\n");
      System.out.println("Price: ");
      System.out.println("[1] Small : RM" + priceSmall);
      System.out.println("[2] Medium: RM" + priceMedium);
      System.out.println("[3] Big   : RM" + priceBig);
      System.out.print("\n");
  }
       
  public void printOrder(){
      System.out.println("Cake Order detail:");
      System.out.println("-------------------------------------------");
      System.out.print("Topping : " );
      for(int i = 0; i < toppingOrder.length; i++){
          System.out.print((i+1) + ") " + toppingOrder[i] + " ");
      }
      System.out.println("\nSize    : " + getSize());
      System.out.println("-------------------------------------------");
      System.out.println("Total Price: RM" + getTotalPrice());
      System.out.println("-------------------------------------------");
  }
}

   class BlackForest extends Cake{
      BlackForest(String name){
      super(name);
   }
   
   public void setCake(String[] t, double pS, double pM, double pB){
       topping = t;
       priceSmall = pS;
       priceMedium = pM;
       priceBig = pB;
   }
}


   public class TestCake1{
      public static void main(String args[]){
        Cake c = new BlackForest("BlackForest");
        String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
        c.setCake(topping, 45.00, 65.00, 80.00);
        c.printCake();
       
        String[] order = {"Chocolate", "Cherries"};
        c.orderCake(order, 1, 2);
        c.printOrder();
     }
 }
        