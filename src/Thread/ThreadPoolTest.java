/**  
* <p>Title: ThreadPoolTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月28日 下午5:44:17 
* @version 1.0  
*/  
package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
* <p>Title: ThreadPoolTest</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月28日 下午5:44:17 
*/
public class ThreadPoolTest {

	public static void main(String[] args) {
		
				// 创建一个可重用固定线程数的线程池,括号内代表最大同时执行的线程数
				ExecutorService pool = Executors.newFixedThreadPool(5);
				//单任务线程池
				//ExecutorService pool = Executors.newSingleThreadExecutor();
				//可变尺寸线程池
				//ExecutorService pool = Executors.newCachedThreadPool();
				// 创建线程
				Thread t1 = new MyThread();
				Thread t2 = new MyThread();
				Thread t3 = new MyThread();
				Thread t4 = new MyThread();
				Thread t5 = new MyThread();
				Thread t6 = new MyThread();
				
				// 将线程放入池中进行执行
				pool.execute(t1);
				pool.execute(t2);
				pool.execute(t3);
				pool.execute(t4);
				pool.execute(t5);
				try {
					t6.sleep(1000);
					//TimeUnit.SECONDS.sleep(4);  
					pool.execute(t6);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 关闭线程池
				pool.shutdown();

	}
}
 class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行。。。");
	}
}