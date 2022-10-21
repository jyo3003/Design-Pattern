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
		try {
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
			while (line1 != null) {
				String[] credentials = line1.split(":");
				if ((credentials[0].equals(userName)) && (credentials[1].equals(userPassword))) {
					System.out.println("It is a matched Buyer");
					userType = 0;
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
			if (userType == Integer.MAX_VALUE) { //Only checking this if the user is not a buyer, to save time.
				String line2 = buffer_seller.readLine();
				while (line2 != null) {
					String[] credentials = line2.split(":");
					if ((credentials[0].equals(userName)) && (credentials[1].equals(userPassword))) {
						System.out.println("It is a matched Seller");
						userType = 1;
						//creating a UserInfoItem object for buyer
						UserInfoItem userinfoitem = new UserInfoItem();
						userinfoitem.name = userName;
						userinfoitem.usertype = UserType.Seller;
						createUser(userinfoitem);
						break;
					}
					line2 = buffer_buyer.readLine();
				}
			}
		}catch(IOException e){
				throw new RuntimeException(e);
			}
			if(userType != Integer.MAX_VALUE) return true;

		return false;
	}

	public void createUser(UserInfoItem userInfoItem1) throws IOException {
		if (userInfoItem1.usertype.equals(UserType.Buyer)) {
			thePerson = new Buyer();
			thePerson.showMenu();
			ReminderVisitor.visitMenu(userInfoItem1);

		}
		else if (userInfoItem1.usertype.equals(UserType.Seller)) {
			thePerson = new Seller();
			thePerson.showMenu();
			ReminderVisitor.visitMenu(userInfoItem1);
		}
	}

	public void createProductList( ) throws FileNotFoundException {
		theProductList = new ClassProductList();
	}


	public void addTrading() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you wish to bid a trade for any product- yes/no");
		String temp = sc.next();
		if(temp.equals("yes")) {
			System.out.println("Enter the name of the product");
			String productName = sc.next();
			System.out.println("Enter the type of the product");
			int productType;
			if (sc.next().equals("Meat")) productType = 0;
			else productType = 1;
			System.out.println("Enter your price for" + productName);
			int price = sc.nextInt();
			Trading trade = new Trading();
			Product product = new Product(productType, productName);
			trade.makeTrade(userName, product, price);
		}
		else System.exit(0);
	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}
	public void submitBidding() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you wish to add a trade for any product- yes/no");
		String temp = sc.next();
		if(temp.equals("yes")) {
			System.out.println("Enter the name of the product");
			String productName = sc.next();
			System.out.println("Enter the type of the product");
			int productType;
			if (sc.next().equals("Meat")) productType = 0;
			else productType = 1;
			System.out.println("Enter your price for" + productName);
			int price = sc.nextInt();
			Trading trade = new Trading();
			Product product = new Product(productType, productName);
			trade.setTrade(userName, product, price);
		}
		else System.exit(0);
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
