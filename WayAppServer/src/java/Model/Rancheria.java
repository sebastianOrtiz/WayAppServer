/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author Ambro
 */
public class Rancheria {

    private int id_rancheria;
    private String nombre;
    private String detalles;

    public Rancheria() {
    }

    public Rancheria(int id_rancheria, String nombre, String detalles) {
        this.id_rancheria = id_rancheria;
        this.nombre = nombre;
        this.detalles = detalles;
    }

    public String toJSON() {
        String s = "{";
//        if (this.id == -1) {
//            s += "\"success\":\"false\"";
//        } else {
        s += "\"id_rancheria\":\"" + this.id_rancheria + "\""
                + ",\"nombre\":\"" + this.nombre + "\""
                + ",\"detalles\":\"" + this.detalles + "\"";
//    }
        s += "}";
        return s;
    }

    public String ListToArrayJson(LinkedList<Rancheria> rancherias) {
        String json = "[";
        for (int i = 0; i < rancherias.size(); i++) {
            if (i == rancherias.size() - 1) {
                json += rancherias.get(i).toJSON();
            } else {
                json += rancherias.get(i).toJSON() + ",";
            }

        }
        json += "]";
        return json;
    }

    /**
     * @return the id_rancheria
     */
    public int getId_rancheria() {
        return id_rancheria;
    }

    /**
     * @param id_rancheria the id_rancheria to set
     */
    public void setId_rancheria(int id_rancheria) {
        this.id_rancheria = id_rancheria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

}
