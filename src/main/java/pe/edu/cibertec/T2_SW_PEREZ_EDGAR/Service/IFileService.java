package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    void guardarArchivo(MultipartFile file)
            throws Exception;

    void guardarArchivos(List<MultipartFile> files)
            throws Exception;

    boolean validarExtension(MultipartFile file)
            throws Exception;
}