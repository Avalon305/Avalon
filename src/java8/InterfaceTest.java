/**  
* <p>Title: Interface.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月6日 下午3:01:03 
* @version 1.0  
*/  
package java8;

public class InterfaceTest {
	   public static void main(String args[]){
	      Vehicle vehicle = new Car();
	      vehicle.print();
	   }
	}
	 
	interface Vehicle {
	   default void print(){
	      System.out.println("我是一辆车!");
	   }
	    
	   static void blowHorn(){
	      System.out.println("按喇叭!!!");
	   }
	}
	 
	interface FourWheeler {
	   default void print(){
	      System.out.println("我是一辆四轮车!");
	   }
	}
	 
	class Car implements Vehicle, FourWheeler {
	   public void print(){
	      Vehicle.super.print();
	      FourWheeler.super.print();
	      Vehicle.blowHorn();
	      System.out.println("我是一辆汽车!");
	   }
	}