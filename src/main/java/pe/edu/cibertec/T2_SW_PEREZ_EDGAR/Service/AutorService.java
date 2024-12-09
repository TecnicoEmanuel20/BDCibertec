package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Repository.AutorRepository;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Autor;

import java.util.List;
import java.util.Optional;
@Service
// EDGAR EMANUEL PEREZ ANCHAYA
@RequiredArgsConstructor

public class AutorService implements IAutorService{

    private final AutorRepository autorRepository;


    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findById(Integer id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
}
