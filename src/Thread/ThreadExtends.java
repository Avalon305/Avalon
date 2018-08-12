/**  
* <p>Title: ThreadTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月27日 下午7:50:50 
* @version 1.0  
*/  
package Thread;

/**  
* <p>Title: ThreadTest</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月27日 下午7:50:50 
*/
/**  
* <p>Title: ThreadTest</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月27日 下午7:55:08 
*/  
public class ThreadExtends extends Thread{
	// 通过继承Thread类,并实现它的抽象方法run()
	// 适当时候创建这一Thread子类的实例来实现多线程机制
	// 一个线程启动后（也即进入就绪状态）一旦获得CPU将自动调用它的run()方法

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("我是Thread子类的线程实例!");
		System.out.println("我将挂起10秒!");
		
		try {
			sleep(10000);// 挂起10秒
			System.out.println("Thread1回到主线程,请稍等,刚才主线程挂起可能还没醒过来！");
		} catch (InterruptedException e) {
			
			return;
			
		}
		// 如果该run()方法顺序执行完了,线程将自动结束,而不会被主线程杀掉
		// 但如果休眠时间过长,则线程还存活,可能被stop()杀掉
		super.run();
	}

}
