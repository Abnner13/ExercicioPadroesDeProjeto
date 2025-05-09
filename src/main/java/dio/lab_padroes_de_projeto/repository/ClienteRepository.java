package dio.lab_padroes_de_projeto.repository;

import dio.lab_padroes_de_projeto.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}