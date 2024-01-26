package nhom55.hcmuaf.security;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import nhom55.hcmuaf.util.MyUtils;

public class SecurityHelper {
  public static boolean isSecurityPage(HttpServletRequest request) {
    String urlPattern = UrlAnalysis.getUrlPattern(request);
    Set<String> roles = SecurityConfig.getAllRoles();

    for (String role : roles) {
      List<String> urlPatterns = SecurityConfig.getListRole(role);
      if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
        return true;
      }
    }
    return false;
  }

  // Kiểm tra 'request' này có vai trò phù hợp hay không?
  public static boolean hasPermission(HttpServletRequest request) {
    String urlPattern = UrlAnalysis.getUrlPattern(request);

    String role = MyUtils.getUserRole(request.getSession());

    List<String> urlPatterns = SecurityConfig.getListRole(role);
    if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
      return true;
    }
    return false;
  }
}

