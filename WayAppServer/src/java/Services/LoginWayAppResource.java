/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.CRUDUsuario;
import Model.Usuario;
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
@Path("loginWayApp")
public class LoginWayAppResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginWayAppResource
     */
    public LoginWayAppResource() {
    }

    /**
     * Retrieves representation of an instance of Services.LoginWayAppResource
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
    public String postLoginResource(@FormParam("user") String user,@FormParam("pass") String pass) {
        CRUDUsuario CRUDUser = new CRUDUsuario();
        Usuario u = CRUDUser.ValidarUsuario(user, pass);
//CRUDCobrador CRUD = new CRUDCobrador();
        //Cobrador c = CRUD.ValidarLogin(user, pass);
        //String res = "usuario = "+user+"\nContrasena = "+pass;
        return  u.toJSON();
    }

    /**
     * PUT method for updating or creating an instance of LoginWayAppResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
