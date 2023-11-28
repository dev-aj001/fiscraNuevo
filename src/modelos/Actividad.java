/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import custom.clases.Funciones;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "actividad")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actividad.findByDecripcion", query = "SELECT a FROM Actividad a WHERE a.decripcion = :decripcion"),
    @NamedQuery(name = "Actividad.findByPrioridad", query = "SELECT a FROM Actividad a WHERE a.prioridad = :prioridad"),
    @NamedQuery(name = "Actividad.findByHoraInicio", query = "SELECT a FROM Actividad a WHERE a.horaInicio = :horaInicio"),
    @NamedQuery(name = "Actividad.findByHoraFin", query = "SELECT a FROM Actividad a WHERE a.horaFin = :horaFin"),
    @NamedQuery(name = "Actividad.findByFecha", query = "SELECT a FROM Actividad a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Actividad.findByTodoElDia", query = "SELECT a FROM Actividad a WHERE a.todoElDia = :todoElDia"),
    @NamedQuery(name = "Actividad.findByEstatus", query = "SELECT a FROM Actividad a WHERE a.estatus = :estatus")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idActividad")
    private Integer idActividad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "decripcion")
    private String decripcion;
    @Column(name = "prioridad")
    private Integer prioridad;
    @Column(name = "horaInicio")
    private String horaInicio;
    @Column(name = "horaFin")
    private String horaFin;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "todoElDia")
    private Short todoElDia;
    @Column(name = "estatus")
    private Integer estatus;
    

    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getTodoElDia() {
        return todoElDia;
    }

    public void setTodoElDia(Short todoElDia) {
        this.todoElDia = todoElDia;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Actividad[ idActividad=" + idActividad + " ]";
    }
    
    public Object[] toArray(){
        /*
        Metodo usado para mostrar de manera mas facil los registros de esta clase
        en una tabla
        */
        
        return new Object[]{getIdActividad(), getNombre(), getDecripcion(), Funciones.formatedFecha(getFecha()), getHoraInicio(), 
            Funciones.prioridadToString(getPrioridad()), Funciones.estatusActividadToString(getEstatus())};
    }

    private String getFormatedFecha() {
        // Crea un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");

        // Convierte la fecha a un String con el formato especificado
        return formatoFecha.format(getFecha());
    }

    private String getFormatedHora() {
        return "[ "+getHoraInicio()+" - "+getHoraFin()+" ]"; 
    }
    
}
