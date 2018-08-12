/**  
* <p>Title: java8Test.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月6日 下午5:11:59 
* @version 1.0  
*/  
package java8;

import java.time.*;
import java.util.Optional;

/**
* <p>Title: java8Test</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月6日 下午5:11:59 
*/
public class java8Test {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年8月6日 下午5:11:59
	 * @param args  
	 */
	 //static 
	  int outerStaticNum = 8;

    public static void main(String args[]) {
        //访问局部变量
           /* int num = 1;
	        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
	        s.convert(2); */ // 输出结果为 3
        //num = 5
        //访问静态变量
        java8Test test = new java8Test();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        test.testZonedDateTime();
        //test.testLocalDateTime();
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(test.sum(a, b));

    }
	 
	   /* public interface Converter<T1, T2> {
	        void convert(int i);
	        //void test(int i);
	    }*/
	    /*public void test(){
	    	 
		        Converter<Integer, String> stringConverter2 = (from) -> {
		            outerStaticNum = 72;
		            System.out.println(String.valueOf(outerStaticNum));
		        };
	    }*/

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    public void testZonedDateTime() {

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        //getRules返回与格林威治时间（UTS时间）的时间差
        System.out.println(id.getRules());
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

    public void testLocalDateTime() {

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
