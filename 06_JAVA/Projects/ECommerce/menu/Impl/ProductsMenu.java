package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.cartModel.Cart;
import model.productModel.Product;
import service.ProductManagementService;
import service.ProductManagementServiceImp;

public class ProductsMenu implements Menu {
    private ProductManagementService instance =  ProductManagementServiceImp.getInstance();
    private ApplicationContext context = ApplicationContext.getInstance();

    private static final String CHECKOUT_COMMAND = "checkout";
    @Override
    public void start() {
        Product[] products = instance.getProducts();
        Scanner sc = new Scanner(System.in);
        if(context.getLoggedInUser() == null) {
            System.out.println("You are not logged in. Please, sign in or create new account");
            return;
        }
        
while(true) {
    printMenuHeader();
    printProducts(products);
    String userInput = sc.next().toLowerCase();
    
    if(userInput.equals("menu")) {
        return;  
        } else if(userInput.equals(CHECKOUT_COMMAND)) {
                Cart cart = context.getSessionCart();
                if(cart == null || cart.isEmpty()) {
                    System.out.println("Your cart is empty. Add products first.");
                } else {
                    new CheckOutMenu().start();
                    return;
                }
            } else {
                try {
                    int productId = Integer.parseInt(userInput);
                    Product product = instance.getProductById(productId);
                    if(product != null) {
                        context.getSessionCart().addProduct(product);
                        System.out.println(product.getProductName() + " added to cart!");
                    } else {
                        System.out.println("Product not found!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }
        }
    }
    @Override
    public void printMenuHeader() {
		System.out.println("***** PRODUCT CATALOG *****");
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");   
    }
    public void printProducts(Product[] products) {
        for(int i = 0; i < products.length; i++) {
            System.out.println(i+1 + ". " + products[i].getProductName());
        }
    }
}
