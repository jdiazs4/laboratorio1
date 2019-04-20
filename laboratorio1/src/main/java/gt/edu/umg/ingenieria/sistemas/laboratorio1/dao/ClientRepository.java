package gt.edu.umg.ingenieria.sistemas.laboratorio1.dao;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    
    @Query("select client from Client client where concat(firstName,' ',lastName) like %?1%")
    List<Client> buscarPorNombreApellido(String query);
}
