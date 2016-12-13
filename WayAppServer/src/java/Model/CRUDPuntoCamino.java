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
public class CRUDPuntoCamino {

    private Conexion conexion;

    public CRUDPuntoCamino() {
        this.conexion = new Conexion();
    }

    public boolean InsertarListaPuntosCamino(LinkedList<PuntoReferencia> puntos) {
        boolean exito = true;
        for (int i = 0; i < puntos.size(); i++) {
            boolean res = this.InsertarPuntoCamino(puntos.get(i), i);
            if (!res) {
                exito = false;
                break;
            }
        }

        return exito;
    }

    public boolean InsertarPuntoCamino(PuntoReferencia punto, int indice) {
        this.conexion.conectar();
        try {
            int estado = 0;
            this.conexion.s = this.conexion.connection.createStatement();
            if (indice == 0) {
                estado = this.conexion.s.executeUpdate("INSERT INTO puntos_camino_rancheria("
                        + "            id_punto_camino, id_rancheria, latitud, longitud, informacion_adicional)"
                        + "    VALUES (" + punto.getId_punto() + ", " + punto.getId_rancheria() + ", " + punto.getLatitud() + ", " + punto.getLongitud() + ", '" + punto.getInformacion_adicional() + "');");
            } else {
                estado = this.conexion.s.executeUpdate("INSERT INTO puntos_camino_rancheria("
                        + "            id_punto_camino, id_rancheria, latitud, longitud, informacion_adicional, "
                        + "            id_punto_camino_anterior)"
                        + "    VALUES (" + punto.getId_punto() + ", " + punto.getId_rancheria() + ", " + punto.getLatitud() + ", " + punto.getLongitud() + ", '" + punto.getInformacion_adicional() + "', "
                        + "            " + punto.getId_punto_anterior() + ");");
            }

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

    public LinkedList<PuntoReferencia> ListarPuntosCamino(int id_rancheria) {
        LinkedList<PuntoReferencia> puntosLimite = new LinkedList<>();
        this.conexion.conectar();
        try {
            this.conexion.s = this.conexion.connection.createStatement();
            ResultSet res = this.conexion.s.executeQuery("SELECT id_punto_camino, id_rancheria, latitud, longitud, informacion_adicional, "
                    + "       id_punto_camino_anterior"
                    + "  FROM puntos_camino_rancheria"
                    + "  WHERE id_rancheria = 1;");
            while (res.next()) {
                PuntoReferencia punto = new PuntoReferencia(res.getInt("id_punto_camino"), res.getInt("id_rancheria"), res.getFloat("latitud"), res.getFloat("longitud"), res.getString("informacion_adicional"), res.getInt("id_punto_camino_anterior"));
                puntosLimite.add(punto);
            }
            //System.out.println("pase");
            return puntosLimite;

        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return puntosLimite;
    }
}
