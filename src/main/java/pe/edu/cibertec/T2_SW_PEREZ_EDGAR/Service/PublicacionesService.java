package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;
// EDGAR EMANUEL PEREZ ANCHAYA
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Repository.PublicacionRepository;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Publicacion;
// EDGAR EMANUEL PEREZ ANCHAYA

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class PublicacionesService implements IPublicacionesService{
    private final PublicacionRepository publicacionRepository;


    @Override
    public List<Publicacion> listadoPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> listarPublicaciones(int id) {
        return publicacionRepository.findById(id);
    }

    @Override
    public Publicacion save(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }
}
