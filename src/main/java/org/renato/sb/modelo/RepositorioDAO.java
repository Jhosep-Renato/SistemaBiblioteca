package org.renato.sb.modelo;

import org.renato.sb.modelo.plantilla.Empleado;
import org.renato.sb.modelo.plantilla.Libro;
import org.renato.sb.mysql.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDAO implements BibliotecaRepositorio{
    @Override
    public boolean validarEmpleado(Empleado empleado) {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM Empleado WHERE nombre=? AND password=?")){

            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getPassword());

            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                return true;
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

        @Override
        public List<Libro> filtrarCategoria(String categoria) {
            List<Libro> libros = new ArrayList<>();

            String sql = "SELECT l.idLibros, l.nombreLibro, c.nombreCategoria FROM Libros AS l INNER JOIN Categoria AS c \n" +
                    "ON l.idCategoria=c.idCategoria WHERE c.nombreCategoria =? ORDER BY l.idLibros ASC";

            try(Connection conn = ConexionBD.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){

                pst.setString(1, categoria);
                ResultSet rst = pst.executeQuery();

                while(rst.next()){
                    Libro libro = new Libro();
                    libro.setId(rst.getInt("idLibros"));
                    libro.setNombreLibro(rst.getString("nombreLibro"));
                    libro.setCategoria(rst.getString("nombreCategoria"));

                    libros.add(libro);
                }
                rst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return libros;
        }

    @Override
    public boolean realizarPrestamo(String fecha, String idEstudiante, String idEmpleado) {
        String sql = "{CALL prestamo_libro(?,?,?,?)}";
        boolean verificar = false;

        try(Connection conn = ConexionBD.getConnection();
            CallableStatement stmt =  conn.prepareCall(sql)){

            stmt.setString(1, fecha);
            stmt.setString(2, idEstudiante);
            stmt.setString(3, idEmpleado);
            stmt.registerOutParameter(4, Types.BOOLEAN);

            stmt.execute();

            verificar = stmt.getBoolean(4);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return verificar;
    }
}
