/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.CRUDPuntoCamino;
import Model.CRUDPuntoLimite;
import Model.CRUDUsuario;
import Model.PuntoReferencia;
import Model.Usuario;
import java.util.LinkedList;
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
@Path("RegistrarPuntos")
public class RegistrarPuntosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistrarPuntosResource
     */
    public RegistrarPuntosResource() {
    }

    /**
     * Retrieves representation of an instance of
     * CobradoresPkg.RegistrarPuntosResource
     *
     * @return an instance of java.lang.String //
     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    @POST
    @Produces("application/json")
    public String postLoginResource(@FormParam("tipo") String tipo, @FormParam("arreglo") String arreglo) {
        String tipoDel = tipo;
        PuntoReferencia pr = new PuntoReferencia();
        LinkedList<PuntoReferencia> puntos = pr.jsonArrayToObjet(arreglo, tipoDel);
        boolean res = false;
        if (tipoDel.equalsIgnoreCase("delimitacion")) {
            CRUDPuntoLimite CRUD = new CRUDPuntoLimite();
            res = CRUD.InsertarListaPuntosLimite(puntos);
        } else {
            CRUDPuntoCamino CRUD = new CRUDPuntoCamino();
            res = CRUD.InsertarListaPuntosCamino(puntos);
        }
        return "{\"success\":\"" + res + "\"}";
    }
//
//    /**
//     * PUT method for updating or creating an instance of RegistrarPuntosResource
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/json")
//    public void putJson(String content) {
//    }
}
