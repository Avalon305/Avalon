/**  
* <p>Title: SwitchUseString.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月4日 下午3:33:10 
* @version 1.0  
*/  
package java7;

/**  
* <p>Title: SwitchUseString</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月4日 下午3:33:10 
*/
public class SwitchUseString {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年8月4日 下午3:33:10
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getTypeOfDayWithSwitchStatement("tuesday");
	}
	public static String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
	     String typeOfDay;
	     switch (dayOfWeekArg) {
	         case "Monday":
	             typeOfDay = "Start of work week";
	             break;
	         case "Tuesday":
	         case "Wednesday":
	         case "Thursday":
	             typeOfDay = "Midweek";
	             break;
	         case "Friday":
	             typeOfDay = "End of work week";
	             break;
	         case "Saturday":
	         case "Sunday":
	             typeOfDay = "Weekend";
	             break;
	         default:
	             throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
	     }
	     System.out.println(typeOfDay);
	     return typeOfDay;
	}
}
