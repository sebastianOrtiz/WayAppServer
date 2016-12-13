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
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author SEBAS
 */
@Path("/ConsultarPuntos")
public class ConsultarPuntosResource {

    @POST
    @Produces("application/json")
    public String postLoginResource(@FormParam("id_rancheria") String id_rancheria) {
        int id_ranch = Integer.parseInt(id_rancheria);
        
        CRUDPuntoLimite CRUDpuntosLimite = new CRUDPuntoLimite();
        CRUDPuntoCamino CRUDpuntocamino = new CRUDPuntoCamino();
        
        PuntoReferencia procesador = new PuntoReferencia();
        
        LinkedList<PuntoReferencia> puntosLimite = CRUDpuntosLimite.ListarPuntosLimite(id_ranch);
        LinkedList<PuntoReferencia> puntosCamino = CRUDpuntocamino.ListarPuntosCamino(id_ranch);
        
        String json = "{\"deliminacion\":"+procesador.ListToArrayJson(puntosLimite)+",\"camino\":"+procesador.ListToArrayJson(puntosCamino)+"}";
        
        return json;
    }
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of ConsultarPuntossResource
//     */
//    public ConsultarPuntossResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of Services.ConsultarPuntossResource
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * POST method for creating an instance of ConsultarPuntosResource
//     * @param content representation for the new resource
//     * @return an HTTP response with content of the created resource
//     */
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response postJson(String content) {
//        //TODO
//        return Response.created(context.getAbsolutePath()).build();
//    }

    /**
     * Sub-resource locator method for {id}
     */
//    @Path("{id}")
//    public ConsultarPuntosResource getConsultarPuntosResource(@PathParam("id") String id) {
//        return ConsultarPuntosResource.getInstance(id);
//    }
}
