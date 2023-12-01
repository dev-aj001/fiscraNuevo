/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelos.Finanza;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.Expediente;
import modelos.Paciente;
import modelos.Visita;

/**
 *
 * @author jairi
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getFinanzaList() == null) {
            paciente.setFinanzaList(new ArrayList<Finanza>());
        }
        if (paciente.getExpedienteList() == null) {
            paciente.setExpedienteList(new ArrayList<Expediente>());
        }
        if (paciente.getVisitaList() == null) {
            paciente.setVisitaList(new ArrayList<Visita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Finanza> attachedFinanzaList = new ArrayList<Finanza>();
            for (Finanza finanzaListFinanzaToAttach : paciente.getFinanzaList()) {
                finanzaListFinanzaToAttach = em.getReference(finanzaListFinanzaToAttach.getClass(), finanzaListFinanzaToAttach.getIdFinanza());
                attachedFinanzaList.add(finanzaListFinanzaToAttach);
            }
            paciente.setFinanzaList(attachedFinanzaList);
            List<Expediente> attachedExpedienteList = new ArrayList<Expediente>();
            for (Expediente expedienteListExpedienteToAttach : paciente.getExpedienteList()) {
                expedienteListExpedienteToAttach = em.getReference(expedienteListExpedienteToAttach.getClass(), expedienteListExpedienteToAttach.getIdExpediente());
                attachedExpedienteList.add(expedienteListExpedienteToAttach);
            }
            paciente.setExpedienteList(attachedExpedienteList);
            List<Visita> attachedVisitaList = new ArrayList<Visita>();
            for (Visita visitaListVisitaToAttach : paciente.getVisitaList()) {
                visitaListVisitaToAttach = em.getReference(visitaListVisitaToAttach.getClass(), visitaListVisitaToAttach.getIdVisita());
                attachedVisitaList.add(visitaListVisitaToAttach);
            }
            paciente.setVisitaList(attachedVisitaList);
            em.persist(paciente);
            for (Finanza finanzaListFinanza : paciente.getFinanzaList()) {
                Paciente oldPacienteidPacienteOfFinanzaListFinanza = finanzaListFinanza.getPacienteidPaciente();
                finanzaListFinanza.setPacienteidPaciente(paciente);
                finanzaListFinanza = em.merge(finanzaListFinanza);
                if (oldPacienteidPacienteOfFinanzaListFinanza != null) {
                    oldPacienteidPacienteOfFinanzaListFinanza.getFinanzaList().remove(finanzaListFinanza);
                    oldPacienteidPacienteOfFinanzaListFinanza = em.merge(oldPacienteidPacienteOfFinanzaListFinanza);
                }
            }
            for (Expediente expedienteListExpediente : paciente.getExpedienteList()) {
                Paciente oldPacienteidPacienteOfExpedienteListExpediente = expedienteListExpediente.getPacienteidPaciente();
                expedienteListExpediente.setPacienteidPaciente(paciente);
                expedienteListExpediente = em.merge(expedienteListExpediente);
                if (oldPacienteidPacienteOfExpedienteListExpediente != null) {
                    oldPacienteidPacienteOfExpedienteListExpediente.getExpedienteList().remove(expedienteListExpediente);
                    oldPacienteidPacienteOfExpedienteListExpediente = em.merge(oldPacienteidPacienteOfExpedienteListExpediente);
                }
            }
            for (Visita visitaListVisita : paciente.getVisitaList()) {
                Paciente oldPacienteidPacienteOfVisitaListVisita = visitaListVisita.getPacienteidPaciente();
                visitaListVisita.setPacienteidPaciente(paciente);
                visitaListVisita = em.merge(visitaListVisita);
                if (oldPacienteidPacienteOfVisitaListVisita != null) {
                    oldPacienteidPacienteOfVisitaListVisita.getVisitaList().remove(visitaListVisita);
                    oldPacienteidPacienteOfVisitaListVisita = em.merge(oldPacienteidPacienteOfVisitaListVisita);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            List<Finanza> finanzaListOld = persistentPaciente.getFinanzaList();
            List<Finanza> finanzaListNew = paciente.getFinanzaList();
            List<Expediente> expedienteListOld = persistentPaciente.getExpedienteList();
            List<Expediente> expedienteListNew = paciente.getExpedienteList();
            List<Visita> visitaListOld = persistentPaciente.getVisitaList();
            List<Visita> visitaListNew = paciente.getVisitaList();
            List<String> illegalOrphanMessages = null;
            for (Finanza finanzaListOldFinanza : finanzaListOld) {
                if (!finanzaListNew.contains(finanzaListOldFinanza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Finanza " + finanzaListOldFinanza + " since its pacienteidPaciente field is not nullable.");
                }
            }
            for (Expediente expedienteListOldExpediente : expedienteListOld) {
                if (!expedienteListNew.contains(expedienteListOldExpediente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Expediente " + expedienteListOldExpediente + " since its pacienteidPaciente field is not nullable.");
                }
            }
            for (Visita visitaListOldVisita : visitaListOld) {
                if (!visitaListNew.contains(visitaListOldVisita)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Visita " + visitaListOldVisita + " since its pacienteidPaciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Finanza> attachedFinanzaListNew = new ArrayList<Finanza>();
            for (Finanza finanzaListNewFinanzaToAttach : finanzaListNew) {
                finanzaListNewFinanzaToAttach = em.getReference(finanzaListNewFinanzaToAttach.getClass(), finanzaListNewFinanzaToAttach.getIdFinanza());
                attachedFinanzaListNew.add(finanzaListNewFinanzaToAttach);
            }
            finanzaListNew = attachedFinanzaListNew;
            paciente.setFinanzaList(finanzaListNew);
            List<Expediente> attachedExpedienteListNew = new ArrayList<Expediente>();
            for (Expediente expedienteListNewExpedienteToAttach : expedienteListNew) {
                expedienteListNewExpedienteToAttach = em.getReference(expedienteListNewExpedienteToAttach.getClass(), expedienteListNewExpedienteToAttach.getIdExpediente());
                attachedExpedienteListNew.add(expedienteListNewExpedienteToAttach);
            }
            expedienteListNew = attachedExpedienteListNew;
            paciente.setExpedienteList(expedienteListNew);
            List<Visita> attachedVisitaListNew = new ArrayList<Visita>();
            for (Visita visitaListNewVisitaToAttach : visitaListNew) {
                visitaListNewVisitaToAttach = em.getReference(visitaListNewVisitaToAttach.getClass(), visitaListNewVisitaToAttach.getIdVisita());
                attachedVisitaListNew.add(visitaListNewVisitaToAttach);
            }
            visitaListNew = attachedVisitaListNew;
            paciente.setVisitaList(visitaListNew);
            paciente = em.merge(paciente);
            for (Finanza finanzaListNewFinanza : finanzaListNew) {
                if (!finanzaListOld.contains(finanzaListNewFinanza)) {
                    Paciente oldPacienteidPacienteOfFinanzaListNewFinanza = finanzaListNewFinanza.getPacienteidPaciente();
                    finanzaListNewFinanza.setPacienteidPaciente(paciente);
                    finanzaListNewFinanza = em.merge(finanzaListNewFinanza);
                    if (oldPacienteidPacienteOfFinanzaListNewFinanza != null && !oldPacienteidPacienteOfFinanzaListNewFinanza.equals(paciente)) {
                        oldPacienteidPacienteOfFinanzaListNewFinanza.getFinanzaList().remove(finanzaListNewFinanza);
                        oldPacienteidPacienteOfFinanzaListNewFinanza = em.merge(oldPacienteidPacienteOfFinanzaListNewFinanza);
                    }
                }
            }
            for (Expediente expedienteListNewExpediente : expedienteListNew) {
                if (!expedienteListOld.contains(expedienteListNewExpediente)) {
                    Paciente oldPacienteidPacienteOfExpedienteListNewExpediente = expedienteListNewExpediente.getPacienteidPaciente();
                    expedienteListNewExpediente.setPacienteidPaciente(paciente);
                    expedienteListNewExpediente = em.merge(expedienteListNewExpediente);
                    if (oldPacienteidPacienteOfExpedienteListNewExpediente != null && !oldPacienteidPacienteOfExpedienteListNewExpediente.equals(paciente)) {
                        oldPacienteidPacienteOfExpedienteListNewExpediente.getExpedienteList().remove(expedienteListNewExpediente);
                        oldPacienteidPacienteOfExpedienteListNewExpediente = em.merge(oldPacienteidPacienteOfExpedienteListNewExpediente);
                    }
                }
            }
            for (Visita visitaListNewVisita : visitaListNew) {
                if (!visitaListOld.contains(visitaListNewVisita)) {
                    Paciente oldPacienteidPacienteOfVisitaListNewVisita = visitaListNewVisita.getPacienteidPaciente();
                    visitaListNewVisita.setPacienteidPaciente(paciente);
                    visitaListNewVisita = em.merge(visitaListNewVisita);
                    if (oldPacienteidPacienteOfVisitaListNewVisita != null && !oldPacienteidPacienteOfVisitaListNewVisita.equals(paciente)) {
                        oldPacienteidPacienteOfVisitaListNewVisita.getVisitaList().remove(visitaListNewVisita);
                        oldPacienteidPacienteOfVisitaListNewVisita = em.merge(oldPacienteidPacienteOfVisitaListNewVisita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Finanza> finanzaListOrphanCheck = paciente.getFinanzaList();
            for (Finanza finanzaListOrphanCheckFinanza : finanzaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Finanza " + finanzaListOrphanCheckFinanza + " in its finanzaList field has a non-nullable pacienteidPaciente field.");
            }
            List<Expediente> expedienteListOrphanCheck = paciente.getExpedienteList();
            for (Expediente expedienteListOrphanCheckExpediente : expedienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Expediente " + expedienteListOrphanCheckExpediente + " in its expedienteList field has a non-nullable pacienteidPaciente field.");
            }
            List<Visita> visitaListOrphanCheck = paciente.getVisitaList();
            for (Visita visitaListOrphanCheckVisita : visitaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Visita " + visitaListOrphanCheckVisita + " in its visitaList field has a non-nullable pacienteidPaciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //Metodos especiales

    List<Paciente> findPacientesActivos() {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT p FROM Paciente p WHERE p.estatus = :estatus";
            TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
            query.setParameter("estatus", 0);   
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Paciente> buscarPacientesPorNombreCompleto(String nombreCompleto) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT p FROM Paciente p " +
                          "WHERE LOWER(CONCAT(p.nombre, ' ', p.apellidoPa, ' ', p.apellidoMa)) LIKE LOWER(:nombreCompleto) ";

            TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
            query.setParameter("nombreCompleto", "%" + nombreCompleto + "%");

            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Paciente> pacientePorCurp(String curp) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT p FROM Paciente p WHERE p.curp = :curp";
            TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
            query.setParameter("curp", curp);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
