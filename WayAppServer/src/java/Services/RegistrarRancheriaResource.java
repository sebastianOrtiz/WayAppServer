/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.CRUDRancheria;
import Model.CRUDUsuario;
import Model.Rancheria;
import Model.Usuario;
import java.math.BigDecimal;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Ambro
 */
@Path("RegistrarRancheria")
public class RegistrarRancheriaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistrarRancheria
     */
    public RegistrarRancheriaResource() {
    }

    /**
     * Retrieves representation of an instance of CobradoresPkg.RegistrarRancheriaResource
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    @POST
    @Produces("application/json")
    public String postLoginResource(@FormParam("id_rancheria") String id_rancheria,@FormParam("nombre") String nombre, @FormParam("detalles") String detalles) {
        Rancheria nuevaRancheria = new Rancheria(Integer.parseInt(id_rancheria), nombre, detalles);
        CRUDRancheria CRUD = new CRUDRancheria();
        boolean res = CRUD.InsertarRancheria(nuevaRancheria);
        //CRUDUsuario CRUDUser = new CRUDUsuario();
        //Usuario u = CRUDUser.ValidarUsuario(user, pass);
        //CRUDCobrador CRUD = new CRUDCobrador();
        //Cobrador c = CRUD.ValidarLogin(user, pass);
        //String res = "usuario = "+user+"\nContrasena = "+pass;
        return  "{\"success\":\""+res+"\"}";
    }
    /**
     * PUT method for updating or creating an instance of RegistrarRancheria
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
