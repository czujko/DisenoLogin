package com.ndynmate.disenologin;

import java.sql.*;

public class ConexionDB {
    private static Connection cn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String sql;

    public void conectar() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void crearTabla() {
        conectar();
        try {
            sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(50) NOT NULL, " +
                    "apellido VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(50) NOT NULL, " +
                    "contrasena VARCHAR(50) NOT NULL);";
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean comprobarUsuario(String nombre, String contrasena) {
        conectar();
        boolean existe = false;
        try {
            sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return existe;
    }

    public void insertarRegistro() {
        conectar();
        try {
            sql = "INSERT INTO usuarios (nombre, apellido, email, contrasena) VALUES (?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, "ndynmate");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "1234");
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
