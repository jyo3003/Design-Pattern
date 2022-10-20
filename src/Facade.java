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


	public boolean login() throws FileNotFoundException {
		System.out.println("Implementing Facade design pattern:");
		//To handle exceptions
		try{
			Scanner sc = new Scanner(System.in);
			//To get username and password from terminal
			System.out.println("Enter the Username:");
			this.userName = sc.next();
			System.out.println("Enter the password:");
			this.userPassword = sc.next();

			//Creating seller and user information files
			File sellerInfo = new File("SellerInfo.txt");
			File buyerInfo = new File("BuyerInfo.txt");

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
					userinfoitem.userType = userType;
					createUser(userinfoitem);
					createProductList();
					//Calling to view the user corresponding menu
					productOperation();
					return true;
				}
				buffer_buyer.readLine();

			}
			//checking if the given user is seller
			String line2 = buffer_seller.readLine();
			while(line2!=null)
			{
				String[] credentials = line1.split(":");
				if((credentials[0].equals(userName)) && (credentials[1].equals(userPassword)))
				{
					System.out.println("It is a matched Seller");
					userType=1;
					//creating a UserInfoItem object for seller
					UserInfoItem userinfoitem = new UserInfoItem();
					userinfoitem.name = userName;
					userinfoitem.userType = userType;
					createUser(userinfoitem);
					createProductList();
					//Calling to view the user corresponding menu
					productOperation();
					return true;
				}
				buffer_seller.readLine();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//If the user entered credentials matches, then using ITERATOR DESIGN PATTERN only to print products
		if(userType != Integer.MAX_VALUE){
			System.out.println("Implementing ITERATOR DESIGN PATTERN");
			ClassProductList classProductList = new ClassProductList();
			Iterator iterator = classProductList.createIterator(); //creating an iterator to iterate through list
			ProductIterator productIterator = new ProductIterator();
			while (productIterator.hasNext(iterator)) {
				System.out.println(productIterator.hasNext(iterator));
			}
		}


        return false;
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

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public void SelectProduct() {

	}

	public void productOperation() {

	}

}
