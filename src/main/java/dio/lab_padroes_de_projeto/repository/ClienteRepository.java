package dio.lab_padroes_de_projeto.repository;

import dio.lab_padroes_de_projeto.model.Cliente;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    @Query("SELECT e FROM Cliente e JOIN FETCH e.roles WHERE e.username = :username")
    Cliente findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}