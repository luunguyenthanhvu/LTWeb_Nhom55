package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDaoImpl;

import java.util.List;

public class ShopService {
    private static ShopService instance;

    private ShopService() {
    }

    public static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopService();
        }
        return instance;
    }
    public List<Products> get20ProductsForEachPage(int index, int quantityDefault) {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return productDaoImpl.get20ProductsForEachPage(index,quantityDefault);
    }
    public List<Products> search(String search, int index, int sizePage) {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return  productDaoImpl.search(search,index,sizePage);
    }
    public List<Products> searchFilter(String sortBy, String order, String search, int index, int sizePage) {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return  productDaoImpl.searchFilter(sortBy,order,search,index,sizePage);
    }
    public List<Products> sortByFilter(int index, int quantityDefault, String sortBy, String order) {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return  productDaoImpl.sortByFilter(index,quantityDefault,sortBy,order);
    }
    public int countTotalRowProductInDatabase(){
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return productDaoImpl.countTotalRowProductInDatabase();
    }
    public int countResultSearchingProduct(String txtSearch) {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        return productDaoImpl.countResultSearchingProduct(txtSearch);
    }

}
