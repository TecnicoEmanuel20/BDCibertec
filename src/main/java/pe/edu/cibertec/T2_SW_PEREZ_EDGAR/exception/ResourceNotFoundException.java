package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.exception;

public class ResourceNotFoundException
        extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
