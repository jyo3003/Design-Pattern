import java.util.*;
import java.io.*;

public class Facade {

	private int userType = Integer.MAX_VALUE;
	private Product theSelectedProduct;
	private int nProductCategory;
	private ClassProductList theProductList;
	private Person thePerson;
	String userName;
	String userPassword;


	public boolean login() throws IOException {
		System.out.println("Implementing FACADE DESIGN PATTERN:");
		//To handle exceptions
		try{
			Scanner sc = new Scanner(System.in);
			//To get username and password from terminal
			System.out.println("Enter the Username:");
			this.userName = sc.next();
			System.out.println("Enter the password:");
			this.userPassword = sc.next();

			//Creating seller and user information files
			File sellerInfo = new File("src/SellerInfo.txt");
			File buyerInfo = new File("src/BuyerInfo.txt");

			//Reading the contents of seller and buyer information files
			FileReader buyer = new FileReader(buyerInfo);
			FileReader seller = new FileReader(sellerInfo);

			//Using BufferedReader to read Text File
			BufferedReader buffer_buyer = new BufferedReader(buyer);
			BufferedReader buffer_seller = new BufferedReader(seller);

			//checking if the given user is buyer
			String line1 = buffer_buyer.readLine();
			while(line1 != null)
			{
				String[] credentials = line1.split(":");
				if((credentials[0].equals(userName)) && (credentials[1].equals(userPassword)))
				{
					System.out.println("It is a matched Buyer");
					userType=0;
					//creating a UserInfoItem object for buyer
					UserInfoItem userinfoitem = new UserInfoItem();
					userinfoitem.name = userName;
					userinfoitem.usertype = UserType.Buyer;
					createUser(userinfoitem);
					break;
				}
				line1 = buffer_buyer.readLine();

			}
			//checking if the given user is seller
			if(userType == Integer.MAX_VALUE) { //Only checking this if the user is not a buyer, to save time.
				String line2 = buffer_seller.readLine();
				while (line2 != null) {
					String[] credentials2 = line2.split(":");
					if ((credentials2[0].equals(userName)) && (credentials2[1].equals(userPassword))) {
						System.out.println("It is a matched Seller");
						userType = 1;
						//creating a UserInfoItem object for seller
						UserInfoItem userinfoitem = new UserInfoItem();
						userinfoitem.name = userName;
						userinfoitem.usertype = UserType.Seller;
						createUser(userinfoitem);
						break;
					}
					line2 = buffer_seller.readLine();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//If the user entered credentials matches, then using ITERATOR DESIGN PATTERN to print products list
		//And using BRIDGE PATTERN to show the menu depending on which kind of product is selected, i.e., meat or produce
		if(userType != Integer.MAX_VALUE){
			System.out.println("Implementing ITERATOR DESIGN PATTERN:");
			System.out.println("Press 1 to see the complete Menu, 2 to see the Meat menu and 3 to see the Produce Menu");
			if(userType == 1){
				System.out.println("Enter 4 to add any items to the menu");
			}
			Scanner sc = new Scanner(System.in);
			int type = sc.nextInt();

			if(type == 1) {
				ClassProductList classProductList = new ClassProductList();
				Iterator iterator = classProductList.createIterator(); //creating an iterator to iterate through list
				ProductIterator productIterator = new ProductIterator();
				while (productIterator.hasNext(iterator)) {
					Product product = productIterator.Next(iterator);
					if (product.getnProductCategory() == 0) {
						System.out.println("Meat" + " : " + product.getproductName());
					}
					else{
						System.out.println("Produce" + " : " + product.getproductName());
					}
				}
			}
			else if(type == 2){
				//Calling to view the user corresponding menu
				productOperation(0);
			}
			else if(type == 3){
				//Calling to view the user corresponding menu
				productOperation(1);
			}
			else{
				System.out.println("Enter the category of the item you want to add");
				String itemType = sc.next();
				System.out.println("Enter the name of the item you want to add");
				String itemName = sc.next();
				Seller seller = new Seller();
				seller.addToMenu(itemType,itemName);
			}
			return true;
		}


        return false;
	}

	public void createUser(UserInfoItem userInfoItem1) {
		if (userInfoItem1.usertype.equals(UserType.Buyer)) {
			thePerson = new Buyer();
		} else if (userInfoItem1.usertype.equals(UserType.Seller)) {
			thePerson = new Seller();
		}
	}

	public void createProductList( ) throws FileNotFoundException {
		theProductList = new ClassProductList();
	}


	//Can implement BRIDGE DESGN Pattern
	public void productOperation(int type) throws FileNotFoundException {
		System.out.println("Implementing BRIDGE and FACTORY DESIGN PATTERN:");
		ProductMenu meatOrProduct;  // Using Factory Design Pattern
		if(type == 0){//Meat
			meatOrProduct = new MeatProductMenu();
			meatOrProduct.showMenu();
			Iterator iterator = meatOrProduct.createIterator(); //creating an iterator to iterate through list
			ProductIterator productIterator = new ProductIterator();
			while (productIterator.hasNext(iterator)) {
				Product product = productIterator.Next(iterator);
				System.out.println("Meat" + " : " + product.getproductName());
			}
		}
		else {
			meatOrProduct = new ProduceProductMenu();
			meatOrProduct.showMenu();
			Iterator iterator = meatOrProduct.createIterator(); //creating an iterator to iterate through list
			ProductIterator productIterator = new ProductIterator();
			while (productIterator.hasNext(iterator)) {
				Product product = productIterator.Next(iterator);
				System.out.println("Produce" + " : " + product.getproductName());
		    }

		}

	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}
	public void submitBidding() {

	}

	public void remind() throws FileNotFoundException {
		ReminderVisitor reminderVisitor = new ReminderVisitor();
		ClassProductList classProductList = new ClassProductList();
		classProductList.accept(reminderVisitor);
	}



	public void AttachProductToUser() {

	}

	public void SelectProduct() {

	}

}
