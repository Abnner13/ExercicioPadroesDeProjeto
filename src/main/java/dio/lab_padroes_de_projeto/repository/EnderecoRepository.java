package dio.lab_padroes_de_projeto.repository;


import dio.lab_padroes_de_projeto.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
