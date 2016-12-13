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
public class CRUDPuntoLimite {

    private Conexion conexion;

    public CRUDPuntoLimite() {
        this.conexion = new Conexion();
    }

    public boolean InsertarListaPuntosLimite(LinkedList<PuntoReferencia> puntos) {
        boolean exito = true;
        for (int i = 0; i < puntos.size(); i++) {
            boolean res = this.InsertarPuntoLimite(puntos.get(i));
            if (!res) {
                exito = false;
                break;
            }
        }
        for (int i = 0; exito && i < puntos.size(); i++) {
            boolean res = this.ActualizarPuntoAnteriorPuntoLimite(puntos.get(i));
            if (!res) {
                exito = false;
                break;
            }
        }

        return exito;
    }

    private boolean ActualizarPuntoAnteriorPuntoLimite(PuntoReferencia punto) {
        this.conexion.conectar();
        try {
            int estado = 0;
            this.conexion.s = this.conexion.connection.createStatement();
            estado = this.conexion.s.executeUpdate("UPDATE puntos_limites_rancherias"
                    + "   SET id_punto_limite_anterior=" + punto.getId_punto_anterior() + ""
                    + " WHERE id_punto_limite=" + punto.getId_punto() + ";");

            if (estado == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Al registrar puntos anteriores");
            return false;
        }
    }

    private boolean InsertarPuntoLimite(PuntoReferencia punto) {
        this.conexion.conectar();
        try {
            int estado = 0;
            this.conexion.s = this.conexion.connection.createStatement();
            estado = this.conexion.s.executeUpdate("INSERT INTO puntos_limites_rancherias("
                    + "            id_punto_limite, id_rancheria, latitud, longitud, informacion_adicional)"
                    + "    VALUES (" + punto.getId_punto() + ", " + punto.getId_rancheria() + ", " + punto.getLatitud() + ", " + punto.getLongitud() + ", '" + punto.getInformacion_adicional() + "');");

            if (estado == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error Insertando puntos limites");
            return false;
        }
    }

    public LinkedList<PuntoReferencia> ListarPuntosLimite(int id_rancheria) {
        LinkedList<PuntoReferencia> puntosLimite = new LinkedList<>();
        this.conexion.conectar();
        try {
            this.conexion.s = this.conexion.connection.createStatement();
            ResultSet res = this.conexion.s.executeQuery("SELECT id_punto_limite, id_rancheria, latitud, longitud, informacion_adicional, "
                    + "       id_punto_limite_anterior"
                    + "  FROM puntos_limites_rancherias"
                    + "  WHERE id_rancheria = "+id_rancheria+";");
            while (res.next()) {
                PuntoReferencia punto = new PuntoReferencia(res.getInt("id_punto_limite"), res.getInt("id_rancheria"), res.getFloat("latitud"), res.getFloat("longitud"), res.getString("informacion_adicional"), res.getInt("id_punto_limite_anterior"));
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
