/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ambro
 */
public class PuntoReferencia {

    private int id_punto;
    private int id_rancheria;
    private float latitud;
    private float longitud;
    private String informacion_adicional;
    private int id_punto_anterior;

    public String toJSON() {
        String s = "{";
//        if (this.id == -1) {
//            s += "\"success\":\"false\"";
//        } else {
        s += "\"id_punto\":\"" + this.id_punto + "\""
                + ",\"id_rancheria\":\"" + this.id_rancheria + "\""
                + ",\"latitud\":\"" + this.latitud + "\""
                + ",\"longitud\":\"" + this.longitud + "\""
                + ",\"informacion_adicional\":\"" + this.informacion_adicional + "\""
                + ",\"id_punto_anterior\":\"" + this.id_punto_anterior + "\"";
//    }
        s += "}";
        return s;
    }

    public String ListToArrayJson(LinkedList<PuntoReferencia> puntos) {
        String json = "[";
        for (int i = 0; i < puntos.size(); i++) {
            if (i == puntos.size() - 1) {
                json += puntos.get(i).toJSON();
            } else {
                json += puntos.get(i).toJSON() + ",";
            }

        }
        json += "]";
        return json;
    }

    @Override
    public String toString() {
        return "Id punto: " + this.id_punto + "\nId rancheria: " + this.getId_rancheria() + "\nLatitud: " + this.getLatitud() + "\nLongitud: " + this.getLongitud() + "\nInformacion adicional: " + this.getInformacion_adicional() + "\nId punto anterior: " + this.id_punto_anterior;
    }

    public PuntoReferencia() {
    }

    public PuntoReferencia(String json) {
        this.CrearDesdeJSON(json);
    }

    public PuntoReferencia(int id_punto, int id_rancheria, float latitud, float longitud, String informacion_adicional, int id_punto_anterior) {
        this.id_punto = id_punto;
        this.id_rancheria = id_rancheria;
        this.latitud = latitud;
        this.longitud = longitud;
        this.informacion_adicional = informacion_adicional;
        this.id_punto_anterior = id_punto_anterior;
    }

    public LinkedList<PuntoReferencia> jsonArrayToObjet(String json, String tipoDelArreglo) {
        String[] sub = SubstraerObjetosJSON(json);
        LinkedList<PuntoReferencia> puntos = new LinkedList<>();
        for (int i = 0; i < sub.length; i++) {
            puntos.add(new PuntoReferencia(sub[i]));

        }

        puntos = this.AsignarIDsYConsecutivos(puntos, puntos.getFirst().getId_rancheria(), tipoDelArreglo);
        return puntos;
    }

    private LinkedList<PuntoReferencia> AsignarIDsYConsecutivos(LinkedList<PuntoReferencia> puntos, int idRancheria, String tipoDelArreglo) {
        System.out.println(tipoDelArreglo);
        int id = (idRancheria * 10000);
        if (tipoDelArreglo.equalsIgnoreCase("delimitacion")){
            id++;
        }else{
            id=id+5001;
        }
        for (int i = 0; i < puntos.size(); i++) {
            puntos.get(i).setId_punto(id);
            if (i > 0) {
                puntos.get(i).setId_punto_anterior(puntos.get(i - 1).getId_punto());
            }
            id++;
        }

        if (tipoDelArreglo.equalsIgnoreCase("delimitacion")) {
            puntos.getFirst().setId_punto_anterior(puntos.getLast().getId_punto());
        } 
        return puntos;
    }

    private String[] SubstraerObjetosJSON(String jsonArray) {
        String sb = jsonArray.substring(1, jsonArray.length() - 1);
        String[] arrayJson = sb.split("\\{");
        String[] arrayJson2 = new String[arrayJson.length - 1];
        for (int i = 1; i < arrayJson.length; i++) {
            arrayJson2[i - 1] = "{" + arrayJson[i];

            if (arrayJson2[i - 1].charAt(arrayJson2[i - 1].length() - 1) == ',') {
                arrayJson2[i - 1] = arrayJson2[i - 1].substring(0, arrayJson2[i - 1].length() - 1);
            }
        }
        return arrayJson2;
    }

    private void CrearDesdeJSON(JSONObject JSON) {
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = JSON;
        this.id_rancheria = Integer.parseInt((String) jsonObject.get("id_rancheria"));
        this.latitud = Float.parseFloat((String) jsonObject.get("latitud"));
        this.longitud = Float.parseFloat((String) jsonObject.get("longitud"));
        this.informacion_adicional = (String) jsonObject.get("informacion_adicional");
    }

    private void CrearDesdeJSON(String JSON) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(JSON);

            JSONObject jsonObject = (JSONObject) obj;
//            this.id_punto = Integer.parseInt((String) jsonObject.get("id_punto")); 
            this.id_rancheria = Integer.parseInt((String) jsonObject.get("id_rancheria"));
            this.latitud = Float.parseFloat((String) jsonObject.get("latitud"));
            this.longitud = Float.parseFloat((String) jsonObject.get("longitud"));
            this.informacion_adicional = (String) jsonObject.get("informacion_adicional");
//            this.id_punto_anterior = Integer.parseInt((String) jsonObject.get("id_punto_anterior"));
//            this.id = Integer.parseInt((String) jsonObject.get("id"));
//            this.sesion = Integer.parseInt((String) jsonObject.get("sesion"));
//            this.cliente = Integer.parseInt((String) jsonObject.get("cliente"));
//            this.cuenta = Integer.parseInt((String) jsonObject.get("cuenta"));
//            this.departamento = (String) jsonObject.get("departamento");
//            this.municipio = (String) jsonObject.get("municipio");
//            this.fecha = (String) jsonObject.get("fecha");
//            this.hora = (String) jsonObject.get("hora");
//            this.porcentaje = Float.parseFloat((String) jsonObject.get("porcentaje"));
//            this.subtotal = Float.parseFloat((String) jsonObject.get("subtotal"));
//            this.inpuestos = Float.parseFloat((String) jsonObject.get("inpuestos"));
//            this.total = Float.parseFloat((String) jsonObject.get("total"));

        } catch (ParseException e) {
            //manejo de error
        }
    }

    /**
     * @return the id_punto
     */
    public int getId_punto() {
        return id_punto;
    }

    /**
     * @param id_punto the id_punto to set
     */
    public void setId_punto(int id_punto) {
        this.id_punto = id_punto;
    }

    /**
     * @return the id_punto_anterior
     */
    public int getId_punto_anterior() {
        return id_punto_anterior;
    }

    /**
     * @param id_punto_anterior the id_punto_anterior to set
     */
    public void setId_punto_anterior(int id_punto_anterior) {
        this.id_punto_anterior = id_punto_anterior;
    }

    /**
     * @return the id_rancheria
     */
    public int getId_rancheria() {
        return id_rancheria;
    }

    /**
     * @return the latitud
     */
    public float getLatitud() {
        return latitud;
    }

    /**
     * @return the longitud
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * @return the informacion_adicional
     */
    public String getInformacion_adicional() {
        return informacion_adicional;
    }

}
