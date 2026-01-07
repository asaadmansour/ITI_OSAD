package service;

import model.productModel.Product;
import model.productModel.ProductImp;


public class ProductManagementServiceImp implements ProductManagementService{ 
    private static ProductManagementService instance;
    private  Product[] products = new Product[0];
    private ProductManagementServiceImp(){};
    private  void initProducts() {
		products = new Product[] {
				new ProductImp(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
				new ProductImp(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
				new ProductImp(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
				new ProductImp(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
				new ProductImp(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
				new ProductImp(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
				new ProductImp(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
				new ProductImp(8, "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
				new ProductImp(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
				new ProductImp(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
		};
    }
     {
        initProducts();
    }
    public static ProductManagementService getInstance() {
        if(instance == null)
            instance =  new ProductManagementServiceImp();
        return instance;
    }
    @Override
    public Product getProductById(int productIdToAddToCart) {
        for (Product product : products) {
            if(product.getId() == productIdToAddToCart) {
                return product;
            }
        }
        return null;
    }
    @Override
    public Product[] getProducts() {
        return products;
    }
    public void clearServiceState() {
        instance = null;
        products = new Product[0];
    }
}
