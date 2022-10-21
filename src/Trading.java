import java.io.*;

public class Trading {

	private String seller;
	private String buyer;
	private Product product;
	private int price;

	public Trading(String seller, Product product, int price) {
		this.seller = seller;
		this.product = product;
		this.price = price;
	}

	public void setTrade(String seller, Product product, int price) throws IOException {
		File trade = new File("src/trade.txt");
		trade.createNewFile();
		FileWriter trade_file = new FileWriter(trade, true);
		trade_file.write(seller + ":" + product+ ":"+ +price);
		trade_file.close();
	}

	public void makeTrade(String buyer, Product product, int buyer_price) throws IOException {
		File productInfo = new File("src/trade.txt");
		//Reading the contents of productInfo file
		FileReader product_file = new FileReader(productInfo);
		BufferedReader buffer_product = new BufferedReader(product_file);
		String line;
		while ((line = buffer_product.readLine()) != null) {
			Object[] temp = line.split(":");
			int category = Integer.MAX_VALUE;
			Product product1 = (Product) temp[1];
			if(product1.getnProductCategory() == product.getnProductCategory() && product1.getproductName() == product.getproductName()){
				int seller_price = (Integer) temp[2];
				if(buyer_price >= seller_price ){
					System.out.println(buyer + " bought the product "+product.getproductName()+" from " + temp[0] + " for " + temp[2] + " dollars.");
				}
				else{
					System.out.println("The seller bid is higher than buyer bid");
				}
			}
			else{
				System.out.println("Invalid product");
			}
		}
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitTrading(this);
	}

}
