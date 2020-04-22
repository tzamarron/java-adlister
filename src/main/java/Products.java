public interface Products {

    // this method will return an object of type 'Product',
        // searched by 'id'
    Product findByID(long id);

    // this method will insert a 'Product' into our table
        //the return of this will be said product's id
    long createProduct(Product product);

    // could add extra method requirements to update/delete/etc
    // i.e. deleteProduct(long id);

    // i.e. updateProduct(Product product);
}
