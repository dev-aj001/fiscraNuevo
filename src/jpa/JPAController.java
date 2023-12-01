package jpa;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.*;

public class JPAController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("NuevoFiscraPU");

    //JPAControllers de cada clase entidad de la base de datos
    ActividadJpaController actividadJPA = new ActividadJpaController(emf);
    EstudioJpaController estudioJPA = new EstudioJpaController(emf);
    ExpedienteJpaController expedienteJPA = new ExpedienteJpaController(emf);
    FamiliarJpaController familiarJPA = new FamiliarJpaController(emf);
    FinanzaJpaController finanzaJPA = new FinanzaJpaController(emf);
    PacienteJpaController pacienteJPA = new PacienteJpaController(emf);
    UsuarioJpaController usuarioJPA = new UsuarioJpaController(emf);
    VisitaJpaController visitaJPA = new VisitaJpaController(emf);
    PagoJpaController pagoJPA = new PagoJpaController(emf);

    //--------------------------------------------------------------------------
    //Metodos para insertar registros
    public void insertActividad(Actividad actividad) {
        actividadJPA.create(actividad);
    }

    public void insertEstudio(Estudio estudio) {
        estudioJPA.create(estudio);
    }

    public void insertExpediente(Expediente expediente) {
        try {
            expedienteJPA.create(expediente);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertFamiliar(Familiar familiar) {
        familiarJPA.create(familiar);
    }

    public void insertFinanza(Finanza finanza) {
        try {
            finanzaJPA.create(finanza);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertPaciente(Paciente paciente) {
        pacienteJPA.create(paciente);
    }

    public void insertUsuario(Usuario usuario) {
        usuarioJPA.create(usuario);
    }

    public void insertVisita(Visita visita) {
        visitaJPA.create(visita);
    }
    
    public void insertPago(Pago pago){
        pagoJPA.create(pago);
    }

    //--------------------------------------------------------------------------
    //Metodos para actualizar registros
    public void updateActividad(Actividad actividad) {
        try {
            actividadJPA.edit(actividad);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEstudio(Estudio estudio) {
        try {
            estudioJPA.edit(estudio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateExpediente(Expediente expediente) {
        try {
            expedienteJPA.edit(expediente);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFamiliar(Familiar familiar) {
        try {
            familiarJPA.edit(familiar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePaciente(Paciente paciente) {
        try {
            pacienteJPA.edit(paciente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUsuario(Usuario usuario) {
        try {
            usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateVisita(Visita visita) {
        try {
            visitaJPA.edit(visita);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePago(Pago pago){
        try {
            pagoJPA.edit(pago);
        } catch (Exception ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------------------------------------------------
    //Metodos para eliminar registros
    public void deleteActividad(Integer id) {
        try {
            actividadJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEstudio(Integer id) {
        try {
            estudioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteExpediente(Integer id) {
        try {
            expedienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFamiliar(Integer id) {
        try {
            familiarJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFinanza(Integer id) {
        try {
            finanzaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePaciente(Integer id) {
        try {
            pacienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUsuario(Integer id) {
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteVisita(Integer id) {
        try {
            visitaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePago(Integer id) {
        try {
            pagoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(JPAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------------------------------------------------
    //Metodos para obtener registros por su id
    public Actividad getActividad(Integer id) {
        return actividadJPA.findActividad(id);
    }

    public Estudio getEstudio(Integer id) {
        return estudioJPA.findEstudio(id);
    }

    public Expediente getExpediente(Integer id) {
        return expedienteJPA.findExpediente(id);
    }

    public Familiar getFamiliar(Integer id) {
        return familiarJPA.findFamiliar(id);
    }

    public Finanza getFinanza(Integer id) {
        return finanzaJPA.findFinanza(id);
    }

    public Paciente getPaciente(Integer id) {
        return pacienteJPA.findPaciente(id);
    }

    public Usuario getUsuario(Integer id) {
        return usuarioJPA.findUsuario(id);
    }

    public Visita getVisita(Integer id) {
        return visitaJPA.findVisita(id);
    }
    
    public Pago getPago(Integer id) {
        return pagoJPA.findPago(id);
    }

    //--------------------------------------------------------------------------
    //Metodos para obtener una lista de los registros
    public List<Actividad> getListaActividad() {
        return actividadJPA.findActividadEntities();
    }

    public List<Estudio> getListaEstudio() {
        return estudioJPA.findEstudioEntities();
    }

    public List<Expediente> getListaExpediente() {
        return expedienteJPA.findExpedienteEntities();
    }

    public List<Familiar> getListaFamiliar() {
        return familiarJPA.findFamiliarEntities();
    }

    public List<Finanza> getListaFinanza() {
        return finanzaJPA.findFinanzaEntities();
    }

    public List<Paciente> getListaPaciente() {
        return pacienteJPA.findPacienteEntities();
    }

    public List<Usuario> getListaUsuario() {
        return usuarioJPA.findUsuarioEntities();
    }

    public List<Visita> getListaVisita() {
        return visitaJPA.findVisitaEntities();
    }

    //--------------------------------------------------------------------------
    //Metodos para obtener conteo de registros
    public int actividadCount() {
        return actividadJPA.getActividadCount();
    }

    public int estudioCount() {
        return estudioJPA.getEstudioCount();
    }

    public int expedienteCount() {
        return expedienteJPA.getExpedienteCount();
    }

    public int familiarCount() {
        return familiarJPA.getFamiliarCount();
    }

    public int finanzaCount() {
        return finanzaJPA.getFinanzaCount();
    }

    public int pacienteCount() {
        return pacienteJPA.getPacienteCount();
    }

    public int usuarioCount() {
        return usuarioJPA.getUsuarioCount();
    }

    public int visitaCount() {
        return visitaJPA.getVisitaCount();
    }

    //--------------------------------------------------------------------------
    //Metodos especiales
    public List<Actividad> getActividadesBynombre(String nombre) {
        return actividadJPA.findActividadByNombre(nombre);
    }

    public List<Visita> getVisitasByFechaYHora(Date fecha, String hora) {
        return visitaJPA.findVisitaByFechaYHora(fecha, hora);
    }

    public List<Usuario> getUsuariosByUsername(String user) {
        return usuarioJPA.findUsuariosByUsername(user);
    }

    public List<Usuario> getUsuariosInactivos() {
        return usuarioJPA.findUsuariosInactivos();
    }
    
    public List<Usuario> getUsuariosActivos() {
        return usuarioJPA.findUsuariosActivos();
    }
    
    public List<Paciente> getPacientesActivos() {
        return pacienteJPA.findPacientesActivos();
    }

}
