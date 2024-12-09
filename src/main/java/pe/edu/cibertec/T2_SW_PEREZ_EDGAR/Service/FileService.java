package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {
    private final Path pathFolder =
            Paths.get("uploads");
    @Override
    public void guardarArchivo(MultipartFile file)
            throws Exception {
        Files.copy(file.getInputStream(),
                this.pathFolder.resolve(
                        file.getOriginalFilename()));
    }
    @Override
    public void guardarArchivos(List<MultipartFile> files)
            throws Exception {
        for (MultipartFile file : files) {
            guardarArchivo(file);
        }
    }
    @Override
    public boolean validarExtension(MultipartFile file) {
        String[] allowedExtensions = {"pdf", "png", "docx"};
        String filename = file.getOriginalFilename();

        // Validar si el nombre del archivo es válido
        if (filename == null || filename.isEmpty()) {
            return false;
        }
        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();


        for (String ext : allowedExtensions) {
            if (ext.equals(extension)) {
                return true;
            }
        }

        return false;
    }

}
