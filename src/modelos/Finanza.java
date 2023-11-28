/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "finanza")
@NamedQueries({
    @NamedQuery(name = "Finanza.findAll", query = "SELECT f FROM Finanza f"),
    @NamedQuery(name = "Finanza.findByIdFinanza", query = "SELECT f FROM Finanza f WHERE f.idFinanza = :idFinanza")})
public class Finanza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFinanza")
    private Integer idFinanza;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteidPaciente;
    @JoinColumn(name = "Pago_idPago", referencedColumnName = "idPago")
    @ManyToOne(optional = false)
    private Pago pagoidPago;

    public Finanza() {
    }

    public Finanza(Integer idFinanza) {
        this.idFinanza = idFinanza;
    }

    public Integer getIdFinanza() {
        return idFinanza;
    }

    public void setIdFinanza(Integer idFinanza) {
        this.idFinanza = idFinanza;
    }

    public Paciente getPacienteidPaciente() {
        return pacienteidPaciente;
    }

    public void setPacienteidPaciente(Paciente pacienteidPaciente) {
        this.pacienteidPaciente = pacienteidPaciente;
    }

    public Pago getPagoidPago() {
        return pagoidPago;
    }

    public void setPagoidPago(Pago pagoidPago) {
        this.pagoidPago = pagoidPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFinanza != null ? idFinanza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finanza)) {
            return false;
        }
        Finanza other = (Finanza) object;
        if ((this.idFinanza == null && other.idFinanza != null) || (this.idFinanza != null && !this.idFinanza.equals(other.idFinanza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Finanza[ idFinanza=" + idFinanza + " ]";
    }
    
}
