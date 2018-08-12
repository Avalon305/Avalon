/**  
* <p>Title: HelloWorld.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月3日 下午9:49:06 
* @version 1.0  
*/  
package ScriptDemo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**  
* <p>Title: HelloWorld</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月3日 下午9:49:06 
*/
public class HelloWorld {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年8月3日 下午9:49:07
	 * @param args  
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval("print ('Hello World')");
	}


}
