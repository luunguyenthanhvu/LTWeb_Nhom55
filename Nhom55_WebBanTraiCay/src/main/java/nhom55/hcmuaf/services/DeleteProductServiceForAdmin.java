package nhom55.hcmuaf.services;

import nhom55.hcmuaf.dao.ProductDAO;

public class DeleteProductServiceForAdmin {
    private static DeleteProductServiceForAdmin instance;
    private DeleteProductServiceForAdmin() {
    }

    public static DeleteProductServiceForAdmin getInstance() {
        if (instance == null) {
            instance = new DeleteProductServiceForAdmin();
        }
        return instance;
    }
    public void deleteProduct(int idProduct) {
        ProductDAO dao = new ProductDAO();
        dao.deleteProduct(idProduct);
    }
}
