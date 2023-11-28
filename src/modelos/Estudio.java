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
@Table(name = "estudio")
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findByIdEstudio", query = "SELECT e FROM Estudio e WHERE e.idEstudio = :idEstudio"),
    @NamedQuery(name = "Estudio.findBySeguro", query = "SELECT e FROM Estudio e WHERE e.seguro = :seguro"),
    @NamedQuery(name = "Estudio.findBySeguroOtro", query = "SELECT e FROM Estudio e WHERE e.seguroOtro = :seguroOtro"),
    @NamedQuery(name = "Estudio.findBySeguroVida", query = "SELECT e FROM Estudio e WHERE e.seguroVida = :seguroVida"),
    @NamedQuery(name = "Estudio.findByAlegias", query = "SELECT e FROM Estudio e WHERE e.alegias = :alegias"),
    @NamedQuery(name = "Estudio.findByEnfermedades", query = "SELECT e FROM Estudio e WHERE e.enfermedades = :enfermedades"),
    @NamedQuery(name = "Estudio.findByTratamientos", query = "SELECT e FROM Estudio e WHERE e.tratamientos = :tratamientos"),
    @NamedQuery(name = "Estudio.findByGastosT", query = "SELECT e FROM Estudio e WHERE e.gastosT = :gastosT"),
    @NamedQuery(name = "Estudio.findByGastos1", query = "SELECT e FROM Estudio e WHERE e.gastos1 = :gastos1"),
    @NamedQuery(name = "Estudio.findByGastos2", query = "SELECT e FROM Estudio e WHERE e.gastos2 = :gastos2"),
    @NamedQuery(name = "Estudio.findByGastos3", query = "SELECT e FROM Estudio e WHERE e.gastos3 = :gastos3"),
    @NamedQuery(name = "Estudio.findByGastos4", query = "SELECT e FROM Estudio e WHERE e.gastos4 = :gastos4"),
    @NamedQuery(name = "Estudio.findByGastos5", query = "SELECT e FROM Estudio e WHERE e.gastos5 = :gastos5"),
    @NamedQuery(name = "Estudio.findByGastos6", query = "SELECT e FROM Estudio e WHERE e.gastos6 = :gastos6"),
    @NamedQuery(name = "Estudio.findByGastos7", query = "SELECT e FROM Estudio e WHERE e.gastos7 = :gastos7"),
    @NamedQuery(name = "Estudio.findByIngresosT", query = "SELECT e FROM Estudio e WHERE e.ingresosT = :ingresosT"),
    @NamedQuery(name = "Estudio.findByTipoCasa", query = "SELECT e FROM Estudio e WHERE e.tipoCasa = :tipoCasa"),
    @NamedQuery(name = "Estudio.findByPersonas", query = "SELECT e FROM Estudio e WHERE e.personas = :personas"),
    @NamedQuery(name = "Estudio.findByEstadoCivil", query = "SELECT e FROM Estudio e WHERE e.estadoCivil = :estadoCivil")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudio")
    private Integer idEstudio;
    @Column(name = "seguro")
    private Integer seguro;
    @Column(name = "seguroOtro")
    private String seguroOtro;
    @Column(name = "seguroVida")
    private Short seguroVida;
    @Column(name = "alegias")
    private String alegias;
    @Column(name = "enfermedades")
    private String enfermedades;
    @Column(name = "tratamientos")
    private String tratamientos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gastosT")
    private Double gastosT;
    @Column(name = "gastos1")
    private Double gastos1;
    @Column(name = "gastos2")
    private Double gastos2;
    @Column(name = "gastos3")
    private Double gastos3;
    @Column(name = "gastos4")
    private Double gastos4;
    @Column(name = "gastos5")
    private Double gastos5;
    @Column(name = "gastos6")
    private Double gastos6;
    @Column(name = "gastos7")
    private Double gastos7;
    @Column(name = "ingresosT")
    private Double ingresosT;
    @Column(name = "tipoCasa")
    private String tipoCasa;
    @Column(name = "personas")
    private Integer personas;
    @Column(name = "estadoCivil")
    private Integer estadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudioidEstudio")
    private List<Expediente> expedienteList;

    public Estudio() {
    }

    public Estudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Integer getSeguro() {
        return seguro;
    }

    public void setSeguro(Integer seguro) {
        this.seguro = seguro;
    }

    public String getSeguroOtro() {
        return seguroOtro;
    }

    public void setSeguroOtro(String seguroOtro) {
        this.seguroOtro = seguroOtro;
    }

    public Short getSeguroVida() {
        return seguroVida;
    }

    public void setSeguroVida(Short seguroVida) {
        this.seguroVida = seguroVida;
    }

    public String getAlegias() {
        return alegias;
    }

    public void setAlegias(String alegias) {
        this.alegias = alegias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Double getGastosT() {
        return gastosT;
    }

    public void setGastosT(Double gastosT) {
        this.gastosT = gastosT;
    }

    public Double getGastos1() {
        return gastos1;
    }

    public void setGastos1(Double gastos1) {
        this.gastos1 = gastos1;
    }

    public Double getGastos2() {
        return gastos2;
    }

    public void setGastos2(Double gastos2) {
        this.gastos2 = gastos2;
    }

    public Double getGastos3() {
        return gastos3;
    }

    public void setGastos3(Double gastos3) {
        this.gastos3 = gastos3;
    }

    public Double getGastos4() {
        return gastos4;
    }

    public void setGastos4(Double gastos4) {
        this.gastos4 = gastos4;
    }

    public Double getGastos5() {
        return gastos5;
    }

    public void setGastos5(Double gastos5) {
        this.gastos5 = gastos5;
    }

    public Double getGastos6() {
        return gastos6;
    }

    public void setGastos6(Double gastos6) {
        this.gastos6 = gastos6;
    }

    public Double getGastos7() {
        return gastos7;
    }

    public void setGastos7(Double gastos7) {
        this.gastos7 = gastos7;
    }

    public Double getIngresosT() {
        return ingresosT;
    }

    public void setIngresosT(Double ingresosT) {
        this.ingresosT = ingresosT;
    }

    public String getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(String tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
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
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Estudio[ idEstudio=" + idEstudio + " ]";
    }
    
}
