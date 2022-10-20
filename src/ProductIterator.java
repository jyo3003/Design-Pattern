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

}
