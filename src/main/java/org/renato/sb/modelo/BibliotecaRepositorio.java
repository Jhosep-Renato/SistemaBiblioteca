package org.renato.sb.modelo;

import org.renato.sb.modelo.plantilla.Empleado;
import org.renato.sb.modelo.plantilla.Libro;

import java.util.List;

public interface BibliotecaRepositorio {
    boolean validarEmpleado(Empleado empleado);
    List<Libro> filtrarCategoria(String categoria);
    boolean realizarPrestamo(String fecha, String idEstudiante, String idEmpleado);
}
