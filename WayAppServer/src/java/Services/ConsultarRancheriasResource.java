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
import java.util.LinkedList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Ambro
 */
@Path("ConsultarRancherias")
public class ConsultarRancheriasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConsultarRancheriasResource
     */
    public ConsultarRancheriasResource() {
    }

    @POST
    @Produces("application/json")
    public String postLoginResource() {
        CRUDRancheria CRUDRancheria = new CRUDRancheria();
        LinkedList<Rancheria> rancherias= CRUDRancheria.ListarRancherias();
        Rancheria r = new Rancheria();
//Usuario u = CRUDUser.ValidarUsuario(user, pass);
//CRUDCobrador CRUD = new CRUDCobrador();
        //Cobrador c = CRUD.ValidarLogin(user, pass);
        //String res = "usuario = "+user+"\nContrasena = "+pass;
        return  r.ListToArrayJson(rancherias);
    }
}
