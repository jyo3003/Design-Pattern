import java.io.FileNotFoundException;
import java.util.Iterator;

public interface ProductMenu {

	public abstract void showMenu() throws FileNotFoundException;

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

	Iterator createIterator();
}
