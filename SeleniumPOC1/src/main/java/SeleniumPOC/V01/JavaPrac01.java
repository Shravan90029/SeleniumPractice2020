package SeleniumPOC.V01;

import java.util.Arrays;

public class JavaPrac01 {
public static String name="Shravan";

public static int maximum(int[] numbers) {
	int maxSoFar=numbers[0];
	for (int num:numbers) {
		if(num>maxSoFar) {
			maxSoFar=num;
		}
	}
return maxSoFar;
}

public void switchMethod() {
	int abc=4;
	switch(abc)
	{
	case 0:
		System.out.println("A for apple");
		break;
	case 1:
		System.out.println("B for Ball");
		break;
	case 3:
		System.out.println("C for Cat");
		break;
	case 4:
	System.out.println("D for dog");
	break;
	}
}
	
	public void switchMethodString() {
		String abc="two";
		switch(abc)
		{
		case "a":
			System.out.println("A for apple");
			break;
		case "aa":
			System.out.println("B for Ball");
			break;
		case "abc":
			System.out.println("C for Cat");
			break;
		case "rfd":
		System.out.println("D for dog");
		break;
		}
		
	}


public static void main(String[] args) {
	int[] numberArray= {22, 54, 123, 64,57, 12,43,23,678,12345};
for (int abc:numberArray) {
	System.out.println("before sorting"+abc);
}
	System.out.println(JavaPrac01.maximum(numberArray));
	System.out.println('K'+'f');
	
	int i=100_00_000;
	System.out.println(i);
	Arrays.sort(numberArray);
	for (int abc:numberArray) {
		System.out.println("Aftersorting"+abc);
	}
	
	int key=57;
	int res=Arrays.binarySearch(numberArray, key);
	System.out.println(res);
}

}
