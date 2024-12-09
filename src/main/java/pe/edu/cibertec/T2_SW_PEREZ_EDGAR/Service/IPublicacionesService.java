package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;

import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IPublicacionesService {
    List<Publicacion> findAll();

    Optional<Publicacion> listarPublicaciones(int id);

    Publicacion save(Publicacion publicacion);
}
