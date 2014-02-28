/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.colportor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import mx.edu.um.mateo.general.model.Usuario;
import mx.edu.um.mateo.rh.model.Colegio;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author osoto
 */
@Entity
@Table (name = "temporada_colportor")
public class TemporadaColportor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @ManyToOne
    private Colportor colportor;
    @ManyToOne
    private Asociado asociado;
    @ManyToOne
    private Temporada temporada;    
    @ManyToOne
    private Colegio colegio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "fecha")
    private Date fecha;
    @Column(nullable = false, length = 56, name ="status")
    private String status;
    @NotBlank
    @Column(nullable = false, length = 65)
    private String objetivo;
    @Column(length = 300)
    private String observaciones;
    
    public TemporadaColportor() {
    }
    
    public TemporadaColportor(Colportor colportor,Usuario asociado,Temporada temporada,Colegio colegio) throws Exception{
        this.colportor = colportor;
        try{
        this.asociado = (Asociado)asociado;
        }catch(ClassCastException e){
            throw new Exception("Se esperaba una clase Asociado pero llego una clase "+asociado.getClass());
        }
        this.temporada = temporada;
        this.colegio = colegio;
        
    }
    public TemporadaColportor(String status,String objetivo, String observaciones){
        this.status = status;
        this.objetivo = objetivo;
        this.observaciones = observaciones;
        Date f = new Date();
        this.fecha = f;
    }
   
    public Usuario getAsociado() {
        return asociado;
    }

    public void setAsociado(Usuario asociado) {
        this.asociado = (Asociado)asociado;
    }

    public Colportor getColportor() {
        return colportor;
    }

    public void setColportor(Colportor colportor) {
        this.colportor = colportor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TemporadaColportor other = (TemporadaColportor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + 
                Objects.hashCode(this.id) +
                Objects.hashCode(this.version);
        return hash;
    }

    @Override
    public String toString() {
        return "TemporadaColportor{" + "fecha=" + fecha + ", status=" + status + ", objetivo=" + objetivo + ", observaciones=" + observaciones + ", colportor=" + colportor + ", asociado=" + asociado + ", temporada=" + temporada + '}';
    }

}