/**  
* <p>Title: Supplier.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月7日 下午5:38:01 
* @version 1.0  
*/  
package java8;

/**  
* <p>Title: Supplier</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月7日 下午5:38:01 
*/

	@FunctionalInterface
	public interface Supplier<T> {
	    T get();

		/**  
		 * <p>Title: Student</p>  
		 * <p>Description: </p>  
		 * @date 2018年8月8日 下午10:54:29
		 * @param object
		 * @return  
		 */  
		static Supplier<Student> Student(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
	}
