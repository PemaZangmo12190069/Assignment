import java.util.*;
public class Question1{
	double one_over_four = 0.25;
	double three_over_four = 0.75;
	int size = 4;
	static int a;
	int remove;
	int top = 0;
	static double length;
	static int Array[];
	public Question1(){
		Array = new int[size];
	}

	//which takes a generic variable as a parameter and adds the element to the dynamic array. 
	public void add(int e){
		Array[top] = e;
		top++;
	}

	//this function does not take a parameter.When called pop deletes the last element in the dynamic array.
	public void pop(){
		top--;
		remove = Array[top];
		Array[top] = 0;
		int count = 0;
		for (int i = 0; i < Array[i]; i++) {
			count++;
		}
		a = count;
		length = (double)a/size;
		System.out.println("Remove Element " + remove);
	}

	//this function takes one integer parameter. When called resize changes the size of the array
	public void resize(){
		if (length == one_over_four) {
			int newArray[] = new int[(size/2)*2];
			for (int i = 0; i < Array.length; i++) {
				newArray[i] =Array[i];
			}
			Array = newArray;
			size = size/2;
			for (int n : newArray) {
				System.out.println(n + " ");
			}
		}
		else if (length == three_over_four) {
			int newArray[] = new int[size*2];
			for (int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			size = size * 2;
			Array = newArray;
			for (int j : newArray) {
				System.out.println(j + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}

	//Does not take ay parameter and returns the number of elements present in the dynamic array.
	public int size(){
		return size;
	}

	//Does not take any parameter and returns the string representation of the dynamic array.
	public String toString(){
		String s = Arrays.toString(Array);
		return s;
	}

	public static void main(String[] args) {
		Question1 obj = new Question1();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);

		obj.pop();
		obj.resize();
		System.out.println("toString " + obj.toString());
		System.out.println("The number of elements in the new Array is " + a);
		System.out.println("The size of the new Array is " + obj.size());
	}
}