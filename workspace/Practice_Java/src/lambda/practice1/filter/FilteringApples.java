package lambda.practice1.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

	public static void main(String... args) {

		List<Apple> inventory = 
				Arrays.asList(new Apple(80, "green"), 
							  new Apple(155, "green"), 
							  new Apple(120, "red"));
		
		//filter method 호출
		//1.anonymous inner class
		List<Apple> list1 = filter(inventory, new ApplePredicate() {
			//filter 를 생성하면서 interface ApplePredicate의 test method를 overide한다.
			@Override
			public boolean test(Apple a) {
				// TODO Auto-generated method stub
				return a.getColor().equals("green");
			}
		});
		//function filter의 test method는 위 override된 process를 거친기 때문에 green인 객체가 나온다.
		System.out.println("list1 : "+list1);
		
		//2. Lambda
		//Lambda 형식으로 인터페이스의 test를 override한다.
		//override of test method => return apple.getColor().equals("red");
		List<Apple> list2 = filter(inventory, apple-> apple.getColor().equals("red"));
		System.out.println("list2 : "+list2);
		
		//3. Lambda
		//override of test method => return apple.getWeight() > 100;
		List<Apple> list3 = filter(inventory, a -> a.getWeight() > 100);
		System.out.println("list3 : "+list3);
		
		//4. filterGreenApples
		List<Apple> list4 = filterGreenApples(inventory);
		System.out.println("list4 : "+list4);
		
		//5. filterApplesByColor
		//Second parameter(color) can be "red" or "green"
		List<Apple> list5 = filterApplesByColor(inventory, "red");
		System.out.println("list5 : "+list5);
		
		//6. filterApplesByOverWeight
		//Second parameter(weight) is integer type value
		List<Apple> list6 = filterApplesByOverWeight(inventory, 80);
		System.out.println("list6 : "+list6);
		
		//7. AppleWeightPredicate
		List<Apple> list7 = filter(inventory, new AppleWeightPredicate());
		System.out.println("list7 : "+list7);
		
		//8. AppleWeightPredicate
		//Color is green
		List<Apple> list8 = filter(inventory, new AppleColorPredicate());
		System.out.println("list8 : "+list8);
		
		//8. AppleRedAndHeavyPredicate
		//Color is red and weight is over 150
		List<Apple> list9 = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println("list9 : "+list9);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByOverWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	interface ApplePredicate {
		public boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor()) && apple.getWeight() > 150;
		}
	}
}