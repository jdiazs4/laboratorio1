package gt.edu.umg.ingenieria.sistemas.laboratorio1.controller;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ClientService;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ReportService reportService;
    
    @Autowired 
    private ClientService clientService;
    
    
    @GetMapping("/buscarTodos")
    public List<Client> buscarTodos(){
        return clientService.buscarTodos();
    }
      
    @GetMapping("/buscarPorNit")
    public Client buscarPorNit(@RequestParam String nit){
        return this.clientService.buscarPorNit(nit);
    }
    
    @GetMapping("/buscarPorNombreApellido")
    public List<Client> buscarPorNombreApellido(@RequestParam String query){
        return this.clientService.buscarPorNombreApellido(query);
    }
    
    @PostMapping("/crearCliente")
    public Client crearCliente(@RequestBody(required = true) Client client) throws Exception{
        return this.clientService.crearClient(client);
    }
    
    @PutMapping("/editarCliente")
    public Client editarCliente(@RequestBody(required = true) Client client){
        return this.clientService.editarCliente(client);
    }
    
    @PutMapping("/editarCliente/{id}/{nit}")
    public Client editarClienteNit(@PathVariable(required = true) long id, @PathVariable(required = true) String nit){
        return this.clientService.editarClienteNit(id, nit);
    }
    
    @PutMapping("/editarCliente/{id}/{firstName}/{lastName}")
    public Client editarClienteNombreApellido(@PathVariable(required = true) long id, @PathVariable(required = true) String firstName, @PathVariable(required = true) String lastName){
        return this.clientService.editarClienteNombreApellido(id, firstName, lastName);
    }
    
    @GetMapping("/generarReporteClientes")
    public String generarReporteClientes(){
        return this.reportService.creaReporte();
    }
}
