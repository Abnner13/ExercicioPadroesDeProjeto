package dio.lab_padroes_de_projeto.security;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public interface SecurityFilterChain {
    boolean matches(HttpServletRequest request);

    List<Filter> getFilters();
}
