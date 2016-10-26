import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 关于 几个 poll push offer 的操作 真是 不论怎么记 都是会忘记
 * 难道太依赖文档了 
 * 
 * 一个linkedlist表的建立方式。使用node 的存储方式
 * 于是这边维持的是表头的数据。add 操作的时间是 o（1）
 * add 加在最后
 * 堆栈的操作
 * push 加在最前面
 * pop 减去最前面
 * 列表的相关操作
 * poll 减去最前面
 * offer 增加最后面
 * @author lin
 *
 */
public class testLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("a,b,c,d,e,f,g".split(",")));
		System.out.println(list);
		list.add("s");
		System.out.println(list);
		list.poll();
		System.out.println("poll"+list);
		list.push("z");
		System.out.println("push"+list);
		list.offer("y");
		System.out.println("offer"+list);
		list.pop();
		System.out.println("pop"+list);
	}
	@Test
	public void testcharat(){
		String abd = "sasdasjlkdad";
		System.out.println(abd.charAt(0));
		System.out.println(Character.isAlphabetic('&'));
	}
}
