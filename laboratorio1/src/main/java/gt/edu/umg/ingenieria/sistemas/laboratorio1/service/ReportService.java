package gt.edu.umg.ingenieria.sistemas.laboratorio1.service;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.dao.ClientRepository;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Service
public class ReportService {
    @Autowired
    private ClientRepository cr;
    
    private static String username= System.getProperty("user.name");
    
    public String creaReporte(){
        String reporte = "";
        String ruta = "//home//" + username + "//Desktop//www";
        
        crearDirectorio(ruta);
        ruta += nombreReporte(ruta);
        
        try {
            File file = new File(ruta);
  
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            List<Client> lista= (List<Client>) this.cr.findAll();
        
            bw.write("FirstName \t Last Name \t NIT \t Phone \t Address");
            bw.newLine();
            
            for(Client e : lista){
                bw.write(e.getFirstName());
                bw.write(" \t ");
                bw.write(e.getLastName());
                bw.write(" \t ");
                bw.write(e.getNit());
                bw.write("\t");
                bw.write(e.getPhone());
                bw.write("\t");
                bw.write(e.getAddress());
                bw.newLine();
            }
            
            bw.close();
            
            reporte = "EL REPORTE FUE GENERADO EN: " + ruta;
            
        } catch (Exception e) {
            e.printStackTrace();
            reporte="NO SE CREO NADA";
        }
        
        return reporte;
    }
    
    private String nombreReporte(String ruta){
        File file = new File(ruta);
        
        int num = file.list().length;
        
        return "//Reporte_" + (num+1) +".html";
    }
    
    private void crearDirectorio(String ruta){
        File f = new File(ruta);
        
        try {
            if (!f.exists()) {
                f.mkdir();
            }
        } catch (Exception e) {
        }
    }
}
