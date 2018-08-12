/**  
* <p>Title: CustomResource.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月4日 下午3:48:19 
* @version 1.0  
*/  
package java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**  
* <p>Title: CustomResource</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月4日 下午3:48:19 
*/
/**
 * @author patterncat
 * @created 2014-07-21
 */
public class CustomResource  implements AutoCloseable {
    public void close() throws Exception {
        System.out.println("进行资源释放。");
    }
    public void useCustomResource() throws Exception {
        try (CustomResource resource = new CustomResource())  {
            System.out.println("使用资源。");
        }
    }
    public static void main(String[] args) {
        try {
            new CustomResource().useCustomResource();
            //CharEqualsTest();
            //Binary();
            //readFile("C:\\Users\\Desktop\\navicat.exe");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void BooleanTest(){
    	 boolean flag = true; 
         flag &= true; 
         System.out.println("true\t&=\ttrue\t==>\t" + flag); 
         flag = true; 
         flag &= false; 
         System.out.println("true\t&=\tfalse\t==>\t" + flag); 
         flag = false; 
         flag &= true; 
         System.out.println("false\t&=\ttrue\t==>\t" + flag); 
         flag = false; 
         flag &= false; 
         System.out.println("false\t&=\tfalse\t==>\t" + flag);


         flag = true;  
         flag |= true;  
         System.out.println("true\t|=\ttrue\t==>\t" + flag);  
         flag = true;  
         flag |= false;  
         System.out.println("true\t|=\tfalse\t==>\t" + flag);   
         flag = false;  
         flag |= true;  
         System.out.println("false\t|=\ttrue\t==>\t" + flag);   
         flag = false;  
         flag |= false;  
         System.out.println("false\t|=\tfalse\t==>\t" + flag+"\n");   

         System.out.println("^=  相同为假，不同为真");  
         flag = true;  
         flag ^= true;  
         System.out.println("true\t^=\ttrue\t==>\t" + flag);  
         flag = true;  
         flag ^= false;  
         System.out.println("true\t^=\tfalse\t==>\t" + flag);   
         flag = false;  
         flag ^= true;  
         System.out.println("false\t^=\ttrue\t==>\t" + flag);   
         flag = false;  
         flag ^= false;  
         System.out.println("false\t^=\tfalse\t==>\t" + flag);  
    }
    
    public static void CharEqualsTest() {
    	Integer one_million = 1_000_000;
    	String j = "1_000_000";
    	Integer i = Integer. valueOf(j);
    	System.out.println("带下划线的String转换成int型实验：");
//    	float pi1 = 3_.1415F; // 无效的; 不能在小数点之前有下划线
//    	float pi2 = 3._1415F; // 无效的; 不能在小数点之后有下划线
//    	long socialSecurityNumber1=999_99_9999_L;//无效的，不能在L下标之前加下划线
//    	int a1 = _52; // 这是一个下划线开头的标识符，不是个数字
//    	int a2 = 5_2; // 有效
//    	int a3 = 52_; // 无效的，不能以下划线结尾
//    	int a4 = 5_______2; // 有效的
//    	int a5 = 0_x52; // 无效，不能在0x之间有下划线
//    	int a6 = 0x_52; // 无效的，不能在数字开头有下划线
//    	int a7 = 0x5_2; // 有效的 (16进制数字)
//    	int a8 = 0x52_; // 无效的，不能以下划线结尾
//    	int a9 = 0_52; // 有效的（8进制数）
//    	int a10 = 05_2; // 有效的（8进制数）
//    	int a11 = 052_; // 无效的，不能以下划线结尾
    	System.out.println(one_million);
    }
    public static void Binary() {
    	int i = 0b0100;
    	int j = 0b1001_1001;
    	System.out.println(j);
    }
    public static String readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(String.format("%n"));
            }
            return builder.toString();
        }
    }
    
    
}