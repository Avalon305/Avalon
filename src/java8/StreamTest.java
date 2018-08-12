/**  
* <p>Title: Stream.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月8日 下午12:16:20 
* @version 1.0  
*/  
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**  
* <p>Title: Stream</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月8日 下午12:16:20 
*/
public class StreamTest {

	public static void main(String [] args, IntStream intStream) {
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		 
		System.out.println("筛选列表: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
		
		long count = Stream.of(1, 2, 3, 4, 5)
		        .count();
		System.out.println("count:" + count);// 打印结果：count:5
	
		Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5))
	       .forEach(integer -> System.out.print(integer + "  "));
		
		Stream<Integer> integerStream = Stream.of(1, 2, 3);
		int a = integerStream.max(Integer::compare).get();
		System.out.println("最大值"+a);

		int a1 = Stream.of(2,1,4,5,3).max(Integer::compare).get();
		int b = Stream.of(2,1,4,5,3).min(Integer::compare).get();
		System.out.println(a1);
		System.out.println(b);
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").
		filter(x -> x.compareTo("Z") > 0).
		reduce("", String::concat);
		System.out.println(concat);
		
		
			boolean allMatch = Stream.of(1, 2, 3, 4)
			    .allMatch(integer -> integer > 0);
			System.out.println("allMatch: " + allMatch); // 打印结果：allMatch: true 
			
			
			boolean iterateMatch = Stream.iterate(-100, item -> item + 1)
					.anyMatch(integer -> integer > 0);
			System.out.println("iterateAnyMatch: " + iterateMatch);
			//无限随机流,会导致后边代码都没法运行
			/*Stream<Double> generateC = Stream.generate(java.lang.Math::random);
			
			boolean generateMatch = generateC
				    .allMatch(integer -> integer > 0);
			System.out.println("generateMatch: " + generateMatch); // 打印结果：allMatch: true 
*/			Integer[] arr = new Integer[]{2, 2, 3, 4, 5, 6};
			Optional<Integer> any = Stream.of(1, 2, 3, 4).findFirst();
			System.out.println("findFirst:"+any);
			Optional<Integer> any1 = Arrays.stream(arr).findAny();
			System.out.println("串行findAny:"+any1);
			List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
			Optional<Integer> any2 = list.parallelStream().findAny();
			System.out.println("并行findAny:"+any2);
			intStream = IntStream.of(1,3,5,7,9);
			int sum = intStream.sum();
			System.out.println(sum);

			
	}


}
