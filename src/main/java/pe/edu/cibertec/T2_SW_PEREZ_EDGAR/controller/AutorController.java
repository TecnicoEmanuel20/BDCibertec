package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service.AutorService;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service.IAutorService;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo.Autor;
// EDGAR EMANUEL PEREZ ANCHAYA
import java.util.List;
// EDGAR EMANUEL PEREZ ANCHAYA
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
    // EDGAR EMANUEL PEREZ ANCHAYA
    private final IAutorService autorService;
    @GetMapping
    public ResponseEntity<List<Autor>>
    listarAutor() {
        List<Autor> autorList =
               autorService.findAll();
        if(autorList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(autorList,
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor
            (@PathVariable Integer id) {
        Autor autor = autorService
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("El autor con ID "
                        + id + " no existe en la base de datos"));
        return new ResponseEntity<>(autor,
                HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Autor> guardarAutor(
            @RequestBody Autor autor) {
        return new ResponseEntity<>(
                autorService.save(autor),
                HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(
            @PathVariable Integer id,
            @RequestBody Autor autor
    ){
       autorService.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("El Autor con ID "
                + id + " no existe en la base de datos"));
        autor.setIdautor(id);
        return new ResponseEntity<>(
                autorService.save(autor),
                HttpStatus.OK);
    }
}// EDGAR EMANUEL PEREZ ANCHAYA
// EDGAR EMANUEL PEREZ ANCHAYA