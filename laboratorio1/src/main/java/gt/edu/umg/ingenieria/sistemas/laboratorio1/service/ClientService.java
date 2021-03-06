package gt.edu.umg.ingenieria.sistemas.laboratorio1.service;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.dao.ClientRepository;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public Client crearClient(Client client) throws Exception{
        
        String nit = client.getNit();
        String nombre = client.getFirstName();
        String apellido =  client.getLastName();
        Date birthDate = client.getBirthDate();
        
        if(nit.length() <=10 && validarNit(nit)){
            
            if(validarEdad(birthDate)){
                
                nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
                client.setFirstName(nombre);

                apellido = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();
                client.setLastName(apellido);

                return this.cr.save(client);
                
            }else{
                throw new Exception("Lo sentimos. El sistema solo permite el registro de usuarios mayores de edad.");
            }
        }else{
            throw new Exception("NIT invalido.");
        }
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
                client.setBirthDate(c.getBirthDate());
            }
        }
        
        return client;
    }
    
    public List<Client> buscarPorNombreApellido(String query){
        return (List<Client>) this.cr.buscarPorNombreApellido(query.replace("*", "%"));
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
    
    private boolean validarNit(String nit){
        boolean resultado;
        try {
            Integer.parseInt(nit);
            resultado=true;
        } catch (Exception e) {
            resultado=false;
        }
        return resultado;
    }
    
    private boolean validarEdad(Date birthDate){
        Date fechaActual = new Date();
        int dias=(int) ((fechaActual.getTime()-birthDate.getTime())/86400000);
        int year = dias/365;
        
        if(year>=18)
        return true;
        return false;
    }
}
