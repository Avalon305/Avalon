/**  
* <p>Title: Student.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月7日 下午6:27:06 
* @version 1.0  
*/  
package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**  
* <p>Title: Student</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月7日 下午6:27:06 
*/
public class Student {
    int no;
    String name;
    String sex;
    float height;
    public Student() {
    	
    }
    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }
    

    public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", sex=" + sex + ", height=" + height + "]";
	}


	public static void main(String[] args) {
    	Student stuA = new Student(1, "A", "M", 184);
    	Student stuB = new Student(2, "B", "G", 163);
    	Student stuC = new Student(3, "C", "M", 175);
    	Student stuD = new Student(4, "D", "G", 158);
    	Student stuE = new Student(5, "E", "M", 170);
    	List<Student> list = new ArrayList<>();
    	list.add(stuA);
    	list.add(stuB);
    	list.add(stuC);
    	list.add(stuD);
    	list.add(stuE);
    	//外迭代
    	Iterator<Student> iterator = list.iterator();
    	while(iterator.hasNext()) {
    	    Student stu = iterator.next();
    	    if (stu.getSex().equals("G")) {

    	        System.out.println(stu.toString());
    	    }
    	}
    	//聚合操作
    	list.stream()
        .filter(student -> student.getSex().equals("G"))
        .forEach(student -> System.out.println("Use java8 Stream "+student.toString()));
    	
    	Consumer<Student> greeter = (p) -> System.out.println("Hello, " + p.name);
    	greeter.accept(stuA);
    	
    	 Supplier<Student> supplier = Student::new;
    	 System.out.println(supplier.get());
    	 
    	 Function<String, Integer> toInteger = Integer::valueOf;
    	 Function<String, String> backToString = toInteger.andThen(String::valueOf);
    	System.out.println(backToString.apply("123")+1);    // 结果：字符串"1231"
    	System.out.println(toInteger.apply("123")+1);//结果：Integer 124
    	
    	Predicate<String> predicate = (s) -> s.length() > 0;
    	predicate.test("foo");              // true
    	predicate.negate().test("foo");     // false
    }
}

