import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Buyer extends Person {

	public void showMenu() throws FileNotFoundException {
		System.out.println("Implementing Bridge Pattern");
		System.out.println("Press 1 to see the complete Menu, 2 to see the Meat menu and 3 to see the Produce Menu");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();

		if(type == 1) {
			completeProductListIterator();
		}
		else if(type == 2){
			ProductMenu meatProductMenu = new MeatProductMenu();
			meatProductMenu.showMenu();
		}
		else if(type == 3){
			ProductMenu produceProductMenu = new ProduceProductMenu();
			produceProductMenu.showMenu();
		}
		else{
			System.out.println("Please check the input entered");
		}
	}

	static void completeProductListIterator() throws FileNotFoundException {
		ClassProductList classProductList = new ClassProductList();
		Iterator iterator = classProductList.createIterator(); //creating an iterator to iterate through list
		ProductIterator productIterator = new ProductIterator();
		while (productIterator.hasNext(iterator)) {
			Product product = productIterator.Next(iterator);
			if (product.getnProductCategory() == 0) {
				System.out.println("Meat" + " : " + product.getproductName());
			} else {
				System.out.println("Produce" + " : " + product.getproductName());
			}
		}
	}


	public ProductMenu CreateProductMenu() {
		return null;
	}

}
