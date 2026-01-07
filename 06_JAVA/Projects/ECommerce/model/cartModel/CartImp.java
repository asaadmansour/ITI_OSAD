package model.cartModel;

import model.productModel.Product;

public class CartImp implements Cart{
    private Product[] products;
        public boolean isEmpty(){
            return products == null || products.length == 0;
        }

        @Override
        public void addProduct(Product product) {
            if (products == null) {
                products = new Product[1];
                products[0] = product;
            } else {
                Product[] newProducts = new Product[products.length + 1];
                for (int i = 0; i < products.length; i++) {
                    newProducts[i] = products[i];
                }
                newProducts[products.length] = product;
                products = newProducts;
            }
        }
        @Override
        public Product[] getProducts() {
            return products;
        }
        @Override
        public void clear(){
            products = null;
        }
}
