/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import custom.clases.Funciones;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellidoPa", query = "SELECT p FROM Paciente p WHERE p.apellidoPa = :apellidoPa"),
    @NamedQuery(name = "Paciente.findByApellidoMa", query = "SELECT p FROM Paciente p WHERE p.apellidoMa = :apellidoMa"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByEstatus", query = "SELECT p FROM Paciente p WHERE p.estatus = :estatus"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByFechaIngreso", query = "SELECT p FROM Paciente p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Paciente.findByFechaEgreso", query = "SELECT p FROM Paciente p WHERE p.fechaEgreso = :fechaEgreso"),
    @NamedQuery(name = "Paciente.findByRazonIngreso", query = "SELECT p FROM Paciente p WHERE p.razonIngreso = :razonIngreso")})
public class Paciente implements Serializable {

    @Column(name = "CURP")
    private String curp;

    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "calle")
    private String calle;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "municipio")
    private String municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteidPaciente")
    private List<Expediente> expedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteidPaciente")
    private List<Visita> visitaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Integer idPaciente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidoPa")
    private String apellidoPa;
    @Column(name = "apellidoMa")
    private String apellidoMa;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "estatus")
    private Integer estatus;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fechaEgreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEgreso;
    @Column(name = "razonIngreso")
    private String razonIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteidPaciente")
    private List<Finanza> finanzaList;

    public Paciente() {
    }

    public Paciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getRazonIngreso() {
        return razonIngreso;
    }

    public void setRazonIngreso(String razonIngreso) {
        this.razonIngreso = razonIngreso;
    }

    public List<Finanza> getFinanzaList() {
        return finanzaList;
    }

    public void setFinanzaList(List<Finanza> finanzaList) {
        this.finanzaList = finanzaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Paciente[ idPaciente=" + idPaciente + " ]";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }
    
    //Metodos especiales
    public Object[] toArray(){
        return new Object[] {getIdPaciente(), getNombre(), getApellidoPa() + " " + 
        getApellidoMa(), getCalle() + ", " + getColonia() + ", " + getMunicipio(), 
        getCorreo(), getTelefono(), getSexo(), Funciones.formatedFecha(getFechaIngreso()) 
        , Funciones.estatusPacienteToString(getEstatus())};
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
