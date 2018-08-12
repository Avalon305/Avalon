//注意在控制台里运行的时候要去掉包名再编译 不然报找不到或无法加载主类错误 也不能有注释啥的 否则报GBK编码错误
package Console;

import java.io.Console;



public class ConsoleTest {
    
    public static void main(String[] args) {
        Console console = System.console();
        if(console!=null){
            String user = new String(console.readLine("Enter user:")); 
            String pwd = new String(console.readPassword("Enter passowrd:"));
            //console.printf("User is:"+user+"/n");
            //console.printf("Password is:"+pwd+"/n");
            System.out.println("User is:"+user);
            System.out.println("Password is:"+pwd);
        }else{
            System.out.println("Console is unavailable");
        }
    }
}
