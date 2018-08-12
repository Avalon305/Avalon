/**  
* <p>Title: Lambda.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月6日 下午3:50:40 
* @version 1.0  
*/  
package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**  
* <p>Title: Lambda</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月6日 下午3:50:40 
*/
public class Lambda {
	   public static void main(String args[]){
		   Lambda tester = new Lambda();
	        
	      // 类型声明
	      MathOperation addition = (int a, int b) -> a + b;
	        
	      // 不用类型声明
	      MathOperation subtraction = (a, b) -> a - b;
	        
	      // 大括号中的返回语句
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
	        
	      // 没有大括号及返回语句
	      MathOperation division = (int a, int b) -> a / b;
	        
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	        
	      // 不用括号
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
	        
	      // 用括号
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
	        
	      greetService1.sayMessage("Runoob");
	      greetService2.sayMessage("Google");
	      
	      //新旧排序
	      List<String> names2 = new ArrayList<String>();
	      names2.add("Google ");
	      names2.add("Runoob ");
	      names2.add("Taobao ");
	      names2.add("Baidu ");
	      names2.add("Sina ");
	        
	      System.out.println("使用 Java 7 语法: ");
	        
	      tester.sortUsingJava7(names2);
	      System.out.println(names2);
	      System.out.println("使用 Java 8 语法: ");
	      tester.sortUsingJava8(names2);
	      System.out.println(names2);
	   }
	    
	   interface MathOperation {
	      int operation(int a, int b);
	   }
	    
	   interface GreetingService {
	      void sayMessage(String message);
	   }
	    
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	   
	   
	   // 使用 java 7 排序
	   private void sortUsingJava7(List<String> names){   
	      Collections.sort(names, new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	         }
	      });
	   }
	   
	   // 使用 java 8 排序
	   private void sortUsingJava8(List<String> names){
	      Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	   }
	}