/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
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

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "familiar")
@NamedQueries({
    @NamedQuery(name = "Familiar.findAll", query = "SELECT f FROM Familiar f"),
    @NamedQuery(name = "Familiar.findByIdFamiliar", query = "SELECT f FROM Familiar f WHERE f.idFamiliar = :idFamiliar"),
    @NamedQuery(name = "Familiar.findByNombre", query = "SELECT f FROM Familiar f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Familiar.findByApellidoPa", query = "SELECT f FROM Familiar f WHERE f.apellidoPa = :apellidoPa"),
    @NamedQuery(name = "Familiar.findByApellidoMa", query = "SELECT f FROM Familiar f WHERE f.apellidoMa = :apellidoMa"),
    @NamedQuery(name = "Familiar.findByParentesco", query = "SELECT f FROM Familiar f WHERE f.parentesco = :parentesco"),
    @NamedQuery(name = "Familiar.findByCalle", query = "SELECT f FROM Familiar f WHERE f.calle = :calle"),
    @NamedQuery(name = "Familiar.findByColonia", query = "SELECT f FROM Familiar f WHERE f.colonia = :colonia"),
    @NamedQuery(name = "Familiar.findByCp", query = "SELECT f FROM Familiar f WHERE f.cp = :cp"),
    @NamedQuery(name = "Familiar.findByTelefono", query = "SELECT f FROM Familiar f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "Familiar.findByCorreo", query = "SELECT f FROM Familiar f WHERE f.correo = :correo"),
    @NamedQuery(name = "Familiar.findByNumExte", query = "SELECT f FROM Familiar f WHERE f.numExte = :numExte"),
    @NamedQuery(name = "Familiar.findByNumInte", query = "SELECT f FROM Familiar f WHERE f.numInte = :numInte"),
    @NamedQuery(name = "Familiar.findByEstado", query = "SELECT f FROM Familiar f WHERE f.estado = :estado"),
    @NamedQuery(name = "Familiar.findByCiudad", query = "SELECT f FROM Familiar f WHERE f.ciudad = :ciudad")})
public class Familiar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFamiliar")
    private Integer idFamiliar;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidoPa")
    private String apellidoPa;
    @Column(name = "apellidoMa")
    private String apellidoMa;
    @Column(name = "parentesco")
    private String parentesco;
    @Column(name = "calle")
    private String calle;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "cp")
    private String cp;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "numExte")
    private String numExte;
    @Column(name = "numInte")
    private String numInte;
    @Column(name = "estado")
    private String estado;
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaridFamiliar")
    private List<Expediente> expedienteList;

    public Familiar() {
    }

    public Familiar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public Integer getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
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

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumExte() {
        return numExte;
    }

    public void setNumExte(String numExte) {
        this.numExte = numExte;
    }

    public String getNumInte() {
        return numInte;
    }

    public void setNumInte(String numInte) {
        this.numInte = numInte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamiliar != null ? idFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiar)) {
            return false;
        }
        Familiar other = (Familiar) object;
        if ((this.idFamiliar == null && other.idFamiliar != null) || (this.idFamiliar != null && !this.idFamiliar.equals(other.idFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Familiar[ idFamiliar=" + idFamiliar + " ]";
    }
    
}
