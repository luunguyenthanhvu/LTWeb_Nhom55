package nhom55.hcmuaf.services;

import java.util.List;
import nhom55.hcmuaf.beans.Providers;
import nhom55.hcmuaf.dao.ProviderDao;
import nhom55.hcmuaf.dao.ProviderDaoImpl;

public class ProviderService {
  private static ProviderService instance;
  private ProviderDao providerDao;
  public ProviderService() {
    providerDao = new ProviderDaoImpl();
  }
  public static ProviderService getInstance() {
    if(instance == null) {
      instance = new ProviderService();
    }
    return instance;
  }
  public List<Providers> getAll() {
    return providerDao.getAllProvider();
  }
}
