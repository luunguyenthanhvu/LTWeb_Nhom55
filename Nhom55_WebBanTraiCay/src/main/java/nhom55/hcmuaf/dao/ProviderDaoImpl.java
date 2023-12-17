package nhom55.hcmuaf.dao;

import java.util.List;
import java.util.stream.Collectors;
import nhom55.hcmuaf.beans.Providers;
import nhom55.hcmuaf.database.JDBIConnector;

public class ProviderDaoImpl implements ProviderDao {

  @Override
  public List<Providers> getAllProvider() {
    return JDBIConnector.get().withHandle(handle -> {
      return handle.createQuery("SELECT * FROM providers")
          .mapToBean(Providers.class)
          .stream()
          .collect(Collectors.toList());
    });
  }
}
