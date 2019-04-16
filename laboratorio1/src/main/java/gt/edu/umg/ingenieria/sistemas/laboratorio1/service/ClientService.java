package gt.edu.umg.ingenieria.sistemas.laboratorio1.service;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.dao.ClientRepository;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josué Barillas (jbarillas)
 */

@Service
public class ClientService {
    @Autowired
    private ClientRepository cr;
    
    public List<Client> buscarTodos (){
        return (List<Client>) this.cr.findAll();
    }
    
    public Client crearClient(Client client){
        return this.cr.save(client);
    }
    
    public Client buscarPorNit(String nit){
        List<Client> list = (List<Client>) this.cr.findAll();
        Client client = new Client();
        
        for(Client c : list ){
            if(c.getNit().equals(nit)){
                client.setId(c.getId());
                client.setFirstName(c.getFirstName());
                client.setLastName(c.getLastName());
                client.setNit(c.getNit());
                client.setPhone(c.getPhone());
                client.setAddress(c.getAddress());
            }
        }
        
        return client;
    }
    
    public List<Client> buscarPorNombreApellido(String query){
         List<Client> list = (List<Client>) this.cr.findAll();
         
         list.stream().filter(client -> (client.getFirstName() + " " + client.getLastName())
                 .matches(query)).collect(Collectors.toList());
          
         return list;
    }
    
    public Client editarCliente(Client client){
        return this.cr.save(client);
    }
    
    public Client editarClienteNit(long id, String nit){
        Client client = this.cr.findById(id).get();
        client.setNit(nit);
        return this.cr.save(client);
    }
    
    public Client editarClienteNombreApellido(long id, String firstName, String lastName){
        Client client = this.cr.findById(id).get();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return this.cr.save(client);
    }
}
