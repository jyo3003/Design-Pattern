public class Product {
    private final int nProductCategory;
    private final String productName;
    public int getnProductCategory() {
        return nProductCategory;
    }

    public String getproductName() {
        return productName;
    }



    public Product(int nProductCategory, String productName) {
        this.nProductCategory = nProductCategory;
        this.productName = productName;
    }
}
