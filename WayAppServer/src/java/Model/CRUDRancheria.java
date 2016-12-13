/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Ambro
 */
public class CRUDRancheria {

    private Conexion conexion;

    public CRUDRancheria() {
        this.conexion = new Conexion();
    }

    public LinkedList<Rancheria> ListarRancherias() {
        LinkedList<Rancheria> rancherias = new LinkedList<>();
        this.conexion.conectar();
        try {
            this.conexion.s = this.conexion.connection.createStatement();
            ResultSet res = this.conexion.s.executeQuery("SELECT id_rancheria, nombre, detalles FROM rancheria;");
            while (res.next()) {
                Rancheria rancheria = new Rancheria(res.getInt("id_rancheria"), res.getString("nombre"), res.getString("detalles"));
                rancherias.add(rancheria);
            }
            //System.out.println("pase");
            return rancherias;

        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return rancherias;
    }

    public boolean InsertarRancheria(Rancheria nuevaRancheria) {
        this.conexion.conectar();
        try {
            this.conexion.s = this.conexion.connection.createStatement();
            int estado = this.conexion.s.executeUpdate("INSERT INTO rancheria("
                    + "            id_rancheria, nombre, detalles)"
                    + "    VALUES ("+nuevaRancheria.getId_rancheria()+", '"+nuevaRancheria.getNombre()+"', '"+nuevaRancheria.getDetalles()+"');");
            if (estado == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error de conexion");
            return false;
        }
    }
}
