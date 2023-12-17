package nhom55.hcmuaf.dao;


import nhom55.hcmuaf.beans.Provider;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderDAO {
    public List<Provider> getProvider() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM Providers ")
                        .mapToBean(Provider.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }

}
