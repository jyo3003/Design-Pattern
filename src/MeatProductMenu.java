import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

//BRIDGE DESIGN PATTERN
public class MeatProductMenu implements ProductMenu {

	public ArrayList<Product> productList;

	public void showMenu() {
		try {
			this.productList = new ArrayList<>();
			File productInfo = new File("src/ProductInfo.txt");
			//Reading the contents of productInfo file
			FileReader product_file = new FileReader(productInfo);
			BufferedReader buffer_product = new BufferedReader(product_file);
			String line;
			while ((line = buffer_product.readLine()) != null) {
				String[] products = line.split(":");
				int category = Integer.MAX_VALUE;
				if (products[0].equals("Meat")) {
					category = 0;
					//creating only Meat Products to add to the list
					Product product = new Product(category, products[1]);
					productList.add(product);
				}

			}
			ProductIterator productIterator = new ProductIterator();
			productIterator.productListIterator(productList);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

		public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

	@Override
	public Iterator createIterator() {
		return this.productList.iterator();
	}

}
