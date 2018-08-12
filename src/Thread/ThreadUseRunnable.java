/**  
* <p>Title: ThreadUseRunnable.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月28日 下午4:49:16 
* @version 1.0  
*/  
package Thread;

/**  
* <p>Title: ThreadUseRunnable</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月28日 下午4:49:16 
*/
public class ThreadUseRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("我是Thread类的线程实例并以实现了Runnable接口的类为参数!");
         System.out.println("我将挂起3秒!");
         
         try
         {
                 Thread.sleep(3000);//挂起1秒
                 System.out.println("Thread2回到主线程,请稍等,刚才主线程挂起可能还没醒过来！");
         }
         catch (InterruptedException e)
         {
                 return;
         }
         //如果该run()方法顺序执行完了,线程将自动结束,而不会被主线程杀掉
         //但如果休眠时间过长,则线程还存活,可能被stop()杀掉
		
	}
}
