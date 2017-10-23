package com.example.ribbon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;


public class LambdaTest {
	
	static List<String> list =  Arrays.asList("i","love","china");
	
	public static void main(String[] args) {
		//threadLambda();
		//compareLambda();
		streamForeach();
	}
	
	public static void threadLambda() {
		new Thread(()->{
			for(int i = 0 ; i < 10 ;i++){
				System.out.println(i);
			}
		}).start();;
	}
	
	public static void compareLambda() {
		List<String> list =  Arrays.asList("d","s","a");
		Collections.sort(list,(a,b) -> (b.compareTo(a)));
		for( String string : list ) {
			System.out.println(string);
		}
	}
	
	public static void streamForeach() {
		List<String> list =  Arrays.asList("d","s","a");
		//list.stream().forEach(str->System.out.println(str));
		list.stream()
			.filter(str -> str.equals("a"))
			.forEach(str->System.out.println(str));
	}
	
	@Test
	public void streamMap() {
		list.stream()
			.map(str->str.toUpperCase())
			.forEach(str->System.out.println(str));
	}
	
	@Test
	public void streamFlatMap() {
		Stream<List<String>> stream = Stream.of(Arrays.asList("1","2"),Arrays.asList("3","4"));
		stream.flatMap(list1->list1.stream())
			.forEach(str->System.out.println(str));
	}
	
	
	@Test
	public void testReduce() {
		list.stream().reduce((a,b)->(a.length()-b.length()>0?a:b));
	}
	
}
