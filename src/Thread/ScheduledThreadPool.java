/**  
* <p>Title: ScheduledThreadPool.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月28日 下午6:02:35 
* @version 1.0  
*/  
package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**  
* <p>Title: ScheduledThreadPool</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月28日 下午6:02:35 
*/
public class ScheduledThreadPool {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年7月28日 下午6:02:35
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			// 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
				ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
				// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
				Thread t1 = new MyThread();
				Thread t2 = new MyThread();
				Thread t3 = new MyThread();
				// 将线程放入池中进行执行
				pool.execute(t1);
				// 使用延迟执行风格的方法
				pool.schedule(t2, 1000, TimeUnit.MILLISECONDS);
				pool.schedule(t3, 10, TimeUnit.MILLISECONDS);
				
				// 关闭线程池
				pool.shutdown();
			

	}

}
