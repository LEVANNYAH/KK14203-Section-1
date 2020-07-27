/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   LECTURER: DR MOHD SHAMRIE SAININ
   LAB 6 EXERCISE 3 (Rewrite Lab 5 Exercise 3 for object-oriented implementation)
*/

import java.util.Scanner;

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
   
   Cake(String name){this.name=name;}
   
   abstract public void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig);
         
   public void cakeOrder(String[] to, int q, int s){
      toppingOrder = to;
      quantity = q;
      size = s;
   }
   
   public double getSizePrice(){
      double sprice=0.0;
      if(size==1) sprice = priceSmall;
      else if(size==2) sprice = priceMedium;
      else if(size==3) sprice = priceBig;
      
      return sprice;
   }
   
   public double getTotalPrice(){
      totalPrice = getSizePrice();
      totalPrice *= quantity;
      totalPrice += (toppingOrder.length*10);
      return totalPrice;  
   }
   
   public int getQuantity(){
      return quantity;  
   }
   
   public String getSize(){
      String size_str="";
      if(size==1) size_str="Small";
      else if (size==2) size_str="Medium";
      else if (size==3) size_str="Large";
      return size_str;
   }
   
   public void printCake(){
      System.out.println("-----------------------------");
      System.out.println("           Cake Menu");
      System.out.println("-----------------------------");
      System.out.println(name + " Cake with available toppings:");
      for(int i=0; i<topping.length; i++){
         System.out.println(i+1 + ") " + topping[i]);
      } 
      System.out.println("\nPrice:");
      System.out.println("[1] Small : RM" + priceSmall);
      System.out.println("[2] Medium: RM" + priceMedium);
      System.out.println("[3] Big   : RM" + priceBig);
   }
   
   //local print order to console
   public void printOrder(){
      System.out.println("\n\nCake Order detail:");
      System.out.println("-------------------------------------------");
      System.out.print("Topping Order: ");
      for(int i=0; i<toppingOrder.length; i++){
         System.out.print(i+1 + ") " + toppingOrder[i] + " ");
      } 
      System.out.println("\nSize    : " + getSize());
      System.out.println("-------------------------------------------");
      System.out.println("Total Price: RM" + getTotalPrice()); 
      System.out.println("-------------------------------------------"); 
   } 
   
   //return print order to GUI call
   public String printOrder_GUI(){
      String txt = "\n\nCake Order detail:\n";
      txt += "-------------------------------------------\n";
      txt += "Topping Order: \n";
      for(int i=0; i<toppingOrder.length; i++){
         txt += "(" + (i+1) + ") " + toppingOrder[i] + " \n";
      } 
      txt += "\nSize        : " + getSize() + "\n";
      txt += "Quantity : " + getQuantity() + "\n";
      txt += "-------------------------------------------\n";
      txt += "Total Price: RM" + getTotalPrice() + "\n"; 
      txt += "-------------------------------------------\n"; 
      return txt;
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

public class TestCake1_Lab6{
   public static void main(String args[]){
      Cake c = new BlackForest("BlackForest");
      String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
      c.setCake(topping, 45.00, 65.00, 80.00);
      c.printCake();
      
      //Initialize order, quantity and size
      String[] order = {"Chocolate", "Cherries"};
      c.cakeOrder(order, 1, 2);
      c.printOrder();  
   }
}