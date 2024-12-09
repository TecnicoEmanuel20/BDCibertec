package pe.edu.cibertec.T2_SW_PEREZ_EDGAR.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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

    // Relación con la tabla de categorías
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idautor", insertable = false, updatable = false, foreignKey =
    @ForeignKey(name = "publicacion_ibfk_1"))
    private Autor autor;
}

