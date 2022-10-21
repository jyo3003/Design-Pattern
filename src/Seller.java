import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Seller extends Person {

	public void showMenu() throws IOException {
		System.out.println("Implementing Bridge Pattern");
		System.out.println("Press 1 to see the complete Menu, 2 to see the Meat menu, 3 to see the Produce Menu and 4 to add items to products list");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();

		if(type == 1) {
			Buyer.completeProductListIterator();
		}
		else if(type == 2){
			ProductMenu meatProductMenu = new MeatProductMenu();
			meatProductMenu.showMenu();
		}
		else if(type == 3){
			ProductMenu produceProductMenu = new ProduceProductMenu();
			produceProductMenu.showMenu();
		}
		else if(type == 4){
			System.out.println("Enter the category of the item you want to add");
			String itemType = sc.next();
			System.out.println("Enter the name of the item you want to add");
			String itemName = sc.next();
			Seller seller = new Seller();
			seller.addToMenu(itemType,itemName);
		}
		else{
			System.out.println("Please check the input entered");
		}
	}



	public void addToMenu(String itemType, String itemName) throws IOException {
		//Adding new items into the Product List
			File productInfo = new File("src/ProductInfo.txt");
			//Reading the contents of productInfo file
			FileWriter product_file = new FileWriter(productInfo, true);
			BufferedWriter products = new BufferedWriter(product_file);
			products.write("\n"+itemType + ":" + itemName);
			products.close();
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

    public void addTrading() {
    }
}
