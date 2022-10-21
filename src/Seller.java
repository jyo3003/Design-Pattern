import java.io.*;
import java.util.ArrayList;

public class Seller extends Person {

	public void showMenu() {

	}

	public void addToMenu(String itemType, String itemName) throws IOException {
		//Adding new items into the Product List
			File productInfo = new File("src/ProductInfo.txt");
			//Reading the contents of productInfo file
			FileWriter product_file = new FileWriter(productInfo, true);
			product_file.write(itemType + ":" + itemName);
			product_file.close();
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
