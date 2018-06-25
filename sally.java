/*
 * Complication: javac Sally.java
 * Execution: CTL F11
 * 
 * Sally goes out each weekend to pick fruit and vegetables from her garden. 
 * She carries a basket with her, reaches her hand out to the various fruits 
 * and vegetables, and places them into the basket. Sally wants to be able to 
 * dump the contents of the basket into a sorting machine that will separate 
 * the fruits from the vegetables. 
 * 
 * Can you design the software for a machine that Sally can use to sort fruits 
 * from vegetables and then print the sum of either fruits or vegetables in 
 * O(1) time?
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Sally {
	static class veggies {
		String[] veggie_array = {"beats","microgreens","watercress","collards","asparagus","spinach"};
		int veggie_count = 0;
		
		// print number of veggies
		void printVeggies (int veggie_count) {
			System.out.println("Number of Vegetables: " + veggie_count);
		}
	}
	static class fruit {
		String[] fruit_array = {"apple","orange", "banana", "peach", "lemon","lime", "strawberry"};
		int fruit_count = 0;
		
		// print number of fruits
		void printFruit (int fruit_count) {
			System.out.println("Number of Fruits: " + fruit_count);
		}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// read in list of garden pickings
		String[] basket = {"apple","orange", "banana", "microgreens","watercress","collards"};
		// create instances of classes
		// veggie class
		Class<veggies> clazz = veggies.class;
		Constructor<?> veggieCon = clazz.getDeclaredConstructors()[0];
		veggies veggie_obj = (veggies) veggieCon.newInstance();
		// fruit class
		Class<fruit> clazz1 = fruit.class;
		Constructor<?> fruitCon = clazz1.getDeclaredConstructors()[0];
		fruit fruit_obj = (fruit) fruitCon.newInstance();

		// sort the basket
		for (int i = 0; i < basket.length; i++) {
			// if vegetable
			if (i < veggie_obj.veggie_array.length) {
				for (int j = 0; j < veggie_obj.veggie_array.length; j++) {
					if (basket[i].equals(veggie_obj.veggie_array[j])) {
						veggie_obj.veggie_count++;
					}
				}
			}
			// if fruit
			if (i < fruit_obj.fruit_array.length) {
				for (int k = 0; k < fruit_obj.fruit_array.length; k++) {
					if (basket[i].equals(fruit_obj.fruit_array[k])) {
						fruit_obj.fruit_count++;
					}
				}
			}
		}
		// print number of fruits and vegetables
		fruit_obj.printFruit(fruit_obj.fruit_count);
		veggie_obj.printVeggies(veggie_obj.veggie_count);
	}

}
