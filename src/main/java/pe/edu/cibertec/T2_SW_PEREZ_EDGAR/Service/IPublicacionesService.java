package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;
// EDGAR EMANUEL PEREZ ANCHAYA
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Publicacion;
// EDGAR EMANUEL PEREZ ANCHAYA
import java.util.List;
import java.util.Optional;

public interface IPublicacionesService {
    List<Publicacion> listadoPublicaciones();

    Optional<Publicacion> listarPublicaciones(int id);

    Publicacion save(Publicacion publicacion);
}
