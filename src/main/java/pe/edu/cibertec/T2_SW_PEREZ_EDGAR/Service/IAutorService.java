package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;

import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Autor;
// EDGAR EMANUEL PEREZ ANCHAYA
import java.util.List;
import java.util.Optional;

public interface IAutorService {

    List<Autor> findAll();

    Optional<Autor> findById(Integer id);

    Autor save(Autor autor);

}
