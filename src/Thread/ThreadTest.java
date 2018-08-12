/**  
* <p>Title: ThreadTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月28日 下午5:00:21 
* @version 1.0  
*/  
package Thread;

import java.io.IOException;

/**  
* <p>Title: ThreadTest</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月28日 下午5:00:21 
*/
public class ThreadTest {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年7月28日 下午5:00:21
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("我是主线程!");
         //下面创建线程实例thread1
         ThreadExtends thread1=new ThreadExtends();
         //创建thread2时以实现了Runnable接口的THhreadUseRunnable类实例为参数
         Thread thread2=new Thread(new ThreadUseRunnable(),"SecondThread");
         thread1.start();//启动线程thread1使之处于就绪状态
         //thread1.setPriority(6);//设置thread1的优先级为6
         //优先级将决定cpu空出时，处于就绪状态的线程谁先占领cpu开始运行
         //优先级范围1到10,MIN_PRIORITY,MAX_PRIORITY,NORM_PAIORITY
         //新线程继承创建她的父线程优先级,父线程通常有普通优先级即5NORM_PRIORITY
         System.out.println("主线程将挂起7秒!");
         try
         {
                 Thread.sleep(7000);//主线程挂起3秒
         }
         catch (InterruptedException e)
         {
                 return;
         }
         System.out.println("第一次挂起7秒结束，回到了主线程!");
         if(thread1.isAlive())
         {   
                 thread1.stop();//如果thread1还存在则杀掉他
                 System.out.println("thread1休眠过长,主线程杀掉了thread1!");
         }
         else
                 System.out.println("主线程没发现thread1,thread1已醒顺序执行结束了!");
         
         thread2.start();//启动thread2
         
         System.out.println("主线程又将第二次挂起7秒!");
         try
         {
                 Thread.sleep(7000);//主线程挂起7秒
         }
         catch (InterruptedException e)
         {
                 return;
         }
         System.out.println("第二次挂起7秒结束，又回到了主线程!");
         if(thread2.isAlive())
         {   
                 thread2.stop();//如果thread2还存在则杀掉他
                 System.out.println("thread2休眠过长，主线程杀掉了thread2!");
         }
         else
         System.out.println("主线程没发现thread2,thread2已醒顺序执行结束了!");
         System.out.println("程序结束按任意键继续!");
         try
         {
                 System.in.read();
         }
         catch (IOException e)
         {
                 System.out.println(e.toString());
         }
          
 
	}

}
