/**  
* <p>Title: Car.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月7日 下午5:32:40 
* @version 1.0  
*/  
package java8;

import java.util.Arrays;
import java.util.List;

class Bus {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
	//Supplier接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
    public static Bus create(final Supplier<Bus> supplier) {
        return supplier.get();
    }
 
    public static void collide(final Bus bus) {
        System.out.println("Collided " + bus.toString());
    }
 
    public void follow(final Bus another) {
        System.out.println("Following the " + another.toString());
    }
 
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
    
    
    public static void main(String[] args) {
    	//构造器引用 它的语法是Class::new，或者更一般的Class< T >::new实例如下
    	final Bus car = Bus.create( Bus::new );
    	final List< Bus > cars = Arrays.asList( car );
    	//静态方法运用 它的语法是Class::static_method，实例如下
    	cars.forEach( Bus::collide );
    	//特定类的任意对象的方法引用 它的语法是Class::method实例如下：
    	cars.forEach( Bus::repair );
    	//特定方法的引用 它的语法是instance(实例)::method实例如下 
    	final Bus police = Bus.create( Bus::new );
    	cars.forEach( police::follow );
    }
}



