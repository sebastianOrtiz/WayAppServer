/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.CRUDPuntoCamino;
import Model.CRUDPuntoLimite;
import Model.PuntoReferencia;
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
@Path("RegistrarPuntosCamino")
public class RegistrarPuntosCaminoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistrarPuntosCaminoResource
     */
    public RegistrarPuntosCaminoResource() {
    }

    @POST
    @Produces("application/json")
    public String postLoginResource(@FormParam("tipo") String tipo, @FormParam("arreglo") String arreglo) {
        String tipoDel = tipo;
        PuntoReferencia pr = new PuntoReferencia();
        LinkedList<PuntoReferencia> puntos = pr.jsonArrayToObjet(arreglo, tipoDel);
        boolean res = false;
        
        for (int i = 0; i < puntos.size(); i++) {
            System.out.println(puntos.get(i).toString());
        }
        
        if(puntos.isEmpty()){
            System.out.println("no hay puntos");
        }
        //CRUDPuntoCamino CRUD = new CRUDPuntoCamino();
        //res = CRUD.InsertarListaPuntosCamino(puntos);
        return "{\"success\":\"" + res + "\"}";
    }
    /**
     * Retrieves representation of an instance of
     * Services.RegistrarPuntosCaminoResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of RegistrarPuntosCaminoResource
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
