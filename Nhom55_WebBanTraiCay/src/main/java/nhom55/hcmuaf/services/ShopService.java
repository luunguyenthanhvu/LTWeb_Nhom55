package nhom55.hcmuaf.services;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

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
        ProductDAO productDAO = new ProductDAO();
        return productDAO.get20ProductsForEachPage(index,quantityDefault);
    }
    public List<Products> search(String search, int index, int sizePage) {
        ProductDAO productDAO = new ProductDAO();
        return  productDAO.search(search,index,sizePage);
    }
    public List<Products> searchFilter(String sortBy, String order, String search, int index, int sizePage) {
        ProductDAO productDAO = new ProductDAO();
        return  productDAO.searchFilter(sortBy,order,search,index,sizePage);
    }
    public List<Products> sortByFilter(int index, int quantityDefault, String sortBy, String order) {
        ProductDAO productDAO = new ProductDAO();
        return  productDAO.sortByFilter(index,quantityDefault,sortBy,order);
    }
    public int countTotalRowProductInDatabase(){
        ProductDAO productDAO = new ProductDAO();
        return productDAO.countTotalRowProductInDatabase();
    }
    public int countResultSearchingProduct(String txtSearch) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.countResultSearchingProduct(txtSearch);
    }

}
