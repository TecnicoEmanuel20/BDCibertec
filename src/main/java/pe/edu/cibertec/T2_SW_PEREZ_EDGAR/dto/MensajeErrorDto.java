package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.dto;
// EDGAR EMANUEL PEREZ ANCHAYA
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class MensajeErrorDto {
    private Integer codigoEstado;
    private Date fechaError;
    private String mensaje;
    private String descripcion;
}
