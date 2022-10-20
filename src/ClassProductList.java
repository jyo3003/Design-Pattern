import java.io.*;
import java.util.Iterator;
import java.util.*;

public class ClassProductList {

	private ProductIterator productIterator;
	public ArrayList<Product> productList = new ArrayList<>();

	//adding the products from productInfo to the array-productList using constructor
	public ClassProductList() throws FileNotFoundException {
		try {
			File productInfo = new File("ProductInfo.txt");
			//Reading the contents of productInfo file
			FileReader product = new FileReader(productInfo);
			BufferedReader buffer_product = new BufferedReader(product);
			String line ;
			while((line= buffer_product.readLine())!=null){
				String[] products = line.split(":");
				int category = 0;
				if(products[0].equals("Meat") || products[0].equals("Produce")){
					category = 1;
				}
				

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
		return null;
	}
}
