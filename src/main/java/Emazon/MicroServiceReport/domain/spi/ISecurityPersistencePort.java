package Emazon.MicroServiceReport.domain.spi;


public interface ISecurityPersistencePort {
    void setToken(String jwtToken);
    String getToken();
    void removeToken();
}