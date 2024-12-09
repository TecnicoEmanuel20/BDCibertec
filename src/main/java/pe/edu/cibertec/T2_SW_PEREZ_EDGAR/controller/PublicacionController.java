package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.controller;
// EDGAR EMANUEL PEREZ ANCHAYA
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service.IPublicacionesService;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Publicacion;
// EDGAR EMANUEL PEREZ ANCHAYA
import java.util.List;
// EDGAR EMANUEL PEREZ ANCHAYA
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/publicacion")
// EDGAR EMANUEL PEREZ ANCHAYA
public class PublicacionController {
    // EDGAR EMANUEL PEREZ ANCHAYA
    private final IPublicacionesService publicacionesService;
    @GetMapping
    public ResponseEntity<List<Publicacion>>
    listarPublicacion() {
        List<Publicacion> publicacionList =
                publicacionesService.listadoPublicaciones();
        if(publicacionList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publicacionList,
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion
            (@PathVariable Integer id) {
        Publicacion publicacion = publicacionesService.listarPublicaciones(id).orElseThrow(()
                        -> new ResourceNotFoundException("El autor con ID "
                        + id + " no existe en la base de datos"));
        return new ResponseEntity<>(publicacion,
                HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Publicacion> guardarPublicacion(
            @RequestBody Publicacion publicacion) {
        return new ResponseEntity<>(
                publicacionesService.save(publicacion),
                HttpStatus.CREATED);
    }
// EDGAR EMANUEL PEREZ ANCHAYA
}
