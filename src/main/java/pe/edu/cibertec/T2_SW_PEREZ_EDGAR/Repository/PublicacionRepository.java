package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Publicacion;
// EDGAR EMANUEL PEREZ ANCHAYA
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
