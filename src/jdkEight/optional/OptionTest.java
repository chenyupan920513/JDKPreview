package jdkEight.optional;

import java.util.Optional;

/**
 * @Author pierre 18-1-25
 */
public class OptionTest {

	public static void main(String[] args) {
//map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
//但flatMap方法中的lambda表达式返回值必须是Optionl实例
//ifPresent方法的参数是一个Consumer的实现类，Consumer类包含一个抽象方法，该抽象方法对传入的值进行处理，只处理没有返回值。
		Optional<String> stringOptional = Optional.of("zhangsan");
		stringOptional.ifPresent(e-> System.out.println("我被处理了。。。"+e));
	}
}
