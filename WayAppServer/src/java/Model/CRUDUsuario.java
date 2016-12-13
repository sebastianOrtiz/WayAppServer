/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;

/**
 *
 * @author Ambro
 */
public class CRUDUsuario {

    private Conexion conexion;

    public CRUDUsuario() {
        this.conexion = new Conexion();
    }

    public Usuario ValidarUsuario(String nombreUsuario, String pass) {
        //Cobrador c = new Cobrador();
        
        Usuario user = new Usuario();
        this.conexion.conectar();
        try {
            this.conexion.s = this.conexion.connection.createStatement();
            ResultSet res = this.conexion.s.executeQuery("SELECT id, nombre_usuario, password, nombre, apellido, telefono, departamento, "
                    + "       municipio, direccion, documento_identidad, rol"
                    + "  FROM usuario WHERE nombre_usuario = '"+nombreUsuario+"' AND password = '"+pass+"';");
            if (res.next()) {
                user = new Usuario(res.getInt("id"), res.getString("nombre_usuario"), res.getString("password"), res.getInt("rol"), res.getString("nombre"), res.getString("apellido"), res.getString("telefono"), res.getString("departamento"), res.getString("municipio"), res.getString("direccion"), res.getLong("documento_identidad"));
                //c = new Cobrador(Integer.parseInt(res.getString("cobrador_id")), res.getString("nombres"), res.getString("apellidos"), res.getString("cedula"), res.getString("telefono"), res.getString("direccion"), res.getString("clave"));
            }

            return user;

        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return user;
    }
}
