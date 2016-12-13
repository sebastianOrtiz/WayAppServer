/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ambro
 */
public class Usuario {

    private int id;
    private String nombre_usuario;
    private String password;
    private int rol;
    private String nombre;
    private String apellido;
    private String telefono;
    private String departamento;
    private String municipio;
    private String direccion;
    private long documento_identidad;
    /**
     * Contructor sin parametros, por defento el id es igual a -1
     */
    public Usuario() {
        this.id = -1;
    }
    
    /**
     * Constructor con parametros
     * 
     * @param id identificador del usuario en la base de datos
     * @param nombre_usuario usuario identificador del sistema
     * @param password contraseña del usuario del sistema
     * @param rol rol del usuario en el sistema
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param telefono telefono del usuario
     * @param departamento departamento de residencia del usuario
     * @param municipio municipio de residencia del usuario
     * @param direccion direccion de residencian del usuario
     * @param documento_identidad documento de identidad del usuario
     */
    public Usuario(int id, String nombre_usuario, String password, int rol, String nombre, String apellido, String telefono, String departamento, String municipio, String direccion, long documento_identidad) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.documento_identidad = documento_identidad;
    }
    
    public String toJSON() {
        String s = "{";
        if (this.id == -1) {
            s += "\"success\":\"false\"";
        } else {
            s += "\"success\":\"true\""
                    + ",\"id\":\"" + this.id + "\""
                    + ",\"nombre_usuario\":\"" + this.nombre_usuario + "\""
                    + ",\"password\":\"" + this.password + "\""
                    + ",\"rol\":\"" + this.rol + "\""
                    + ",\"nombre\":\"" + this.nombre + "\""
                    + ",\"apellido\":\"" + this.apellido + "\""
                    + ",\"telefono\":\"" + this.telefono + "\""
                    + ",\"departamento\":\"" + this.departamento + "\""
                    + ",\"municipio\":\"" + this.municipio + "\""
                    + ",\"direccion\":\"" + this.direccion + "\""
                    + ",\"documento_identidad\":\"" + this.documento_identidad + "\"";
        }
        s += "}";
        return s;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol) {
        this.rol = rol;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the documento_identidad
     */
    public long getDocumento_identidad() {
        return documento_identidad;
    }

    /**
     * @param documento_identidad the documento_identidad to set
     */
    public void setDocumento_identidad(long documento_identidad) {
        this.documento_identidad = documento_identidad;
    }
}
