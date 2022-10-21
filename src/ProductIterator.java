import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductIterator {

	private ClassProductList classProductList;

	public boolean hasNext(Iterator classProductListIterator) {
		if(classProductListIterator != null) {
			return classProductListIterator.hasNext();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public Product Next(Iterator classProductListIterator) {
		if (this.hasNext(classProductListIterator)) {
			return (Product) classProductListIterator.next();
		} else {
			return null;
		}
	}

	static void productListIterator(ArrayList<Product> productList) throws FileNotFoundException {

		System.out.println("Implementing ITERATOR DESIGN PATTERN");
		for(int i=0;i< productList.size();i++){
			if(productList.get(i).getnProductCategory() == 0){
				System.out.println("Meat:" + productList.get(i).getproductName());
			}
			else{
				System.out.println("Produce:" + productList.get(i).getproductName());
			}
		}

	}

	@SuppressWarnings("rawtypes")
	public void MoveToHead(Iterator classProductListIterator) {
		System.out.println("Head is moved..");
	}


	@SuppressWarnings("rawtypes")
	public void Remove(Iterator classProductListIterator) {
		if (this.hasNext(classProductListIterator)) {
			classProductListIterator.next();
		}

	}

	public void iterator(ArrayList<Product> productList) {
	}
}
