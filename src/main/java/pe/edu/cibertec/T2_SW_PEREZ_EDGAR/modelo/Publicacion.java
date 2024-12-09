package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
// EDGAR EMANUEL PEREZ ANCHAYA
@Getter
@Setter
@Entity
@Table(name= "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private Date fechpublicacion;
    private Integer idautor;

}

