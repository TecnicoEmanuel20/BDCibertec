package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service.IFileService;
import pe.edu.cibertec.T2_SW_PEREZ_EDGAR.dto.ArchivoDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    private final IFileService fileService;

    @PostMapping("/upload-multiple")
    public ResponseEntity<?> subirArchivos(
            @RequestParam("files") List<MultipartFile> files
    ) {
        try {
            if (files.size() != 3) {
                return ResponseEntity.badRequest().body("Debes subir exactamente 3 archivos.");
            }
            for (MultipartFile file : files) {
                if (!fileService.validarExtension(file)) {
                    return ResponseEntity.badRequest().body("Solo se permiten archivos con extensiones PDF, PNG o DOCX.");
                }
            }

            fileService.guardarArchivos(files);
            return ResponseEntity.ok().body("Archivos subidos correctamente.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar los archivos.");
        }
    }

    @PostMapping("/upload-single")
    public ResponseEntity<?> subirUnSoloArchivo(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Nombre del archivo: " + file.getOriginalFilename());
            System.out.println("Tamaño del archivo: " + file.getSize());

            if (file.getSize() > 25 * 1024 * 1024) {
                return ResponseEntity.badRequest().body("El tamaño máximo del archivo es de 25MB.");
            }

            fileService.guardarArchivo(file);
            return ResponseEntity.ok().body("Archivo subido correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al procesar el archivo.");
        }
    }


}
