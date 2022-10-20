import java.io.*;
import java.util.Iterator;
import java.util.*;

public class ClassProductList {

	private ProductIterator productIterator;

	public ArrayList<Product> productList;

	public ArrayList<Product> getProductList() {
		return productList;
	}

	//adding the products from productInfo to the array-productList using constructor
	public ClassProductList() throws FileNotFoundException {
		try {
			this.productList = new ArrayList<>();
			File productInfo = new File("src/ProductInfo.txt");
			//Reading the contents of productInfo file
			FileReader product_file = new FileReader(productInfo);
			BufferedReader buffer_product = new BufferedReader(product_file);
			String line ;
			while((line= buffer_product.readLine())!=null){
				String[] products = line.split(":");
				int category = Integer.MAX_VALUE;
				if(products[0].equals("Meat")){
					category = 0;
				}
				else if(products[0].equals("Produce")){
					category = 1;
				}
				else {
					System.out.println("Wrong or Invalid product");
					System.out.println("exit...");

					// Terminate JVM
					System.exit(0);
				}
				//creating a new Product to add to the list
				Product product = new Product(category, products[1]);
				productList.add(product);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void accept(NodeVisitor visitor) {

	}

	public Iterator createIterator() {
		return this.productList.iterator();
	}


	@Override
	public String toString() {
		return "ClassProductList{" +  "product=" + productList + '}';
	}
}
