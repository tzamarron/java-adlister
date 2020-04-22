import java.util.ArrayList;
import java.util.List;

// This is our DAO(data access object, or data access class)
public class ListProductsDao implements Products{
    // list all the products, find a product by ID, create a product

    // this will list all the products in the database table
    private List<Product> products;

    // Constructor for this DAO class
    public ListProductsDao(){
        this.products = new ArrayList<>();
        // add some dummy data
    }

    // TODO: Implement our interface requirements (from Products.java)

    @Override
    public Product findByID(long id) {
        // We want to return the 'Product' object for the ID passed in
        // This will return the full row in the Database
        // i.e. id | title | priceInCents | description (the full row)
//        return products.get();
        return products.get((int)id-1);
    }

    @Override
    public long createProduct(Product product) {
        // Create a product and insert to our ArrayList (eventually, the DB)
        // assign an ID
        product.setId(products.size()+1); // same as auto_increment
                    // this ID will always be unique
        // add a new Product ot the ArrayList
        products.add(product); // when we call the createProduct method,
                    // we are sending in a 'Product' type object
                    // this will add that object to the ArrayList
        return product.getId();
    }
}
