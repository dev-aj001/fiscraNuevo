/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import jpa.exceptions.PreexistingEntityException;
import modelos.Finanza;
import modelos.Paciente;
import modelos.Pago;

/**
 *
 * @author jairi
 */
public class FinanzaJpaController implements Serializable {

    public FinanzaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Finanza finanza) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteidPaciente = finanza.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente = em.getReference(pacienteidPaciente.getClass(), pacienteidPaciente.getIdPaciente());
                finanza.setPacienteidPaciente(pacienteidPaciente);
            }
            Pago pagoidPago = finanza.getPagoidPago();
            if (pagoidPago != null) {
                pagoidPago = em.getReference(pagoidPago.getClass(), pagoidPago.getIdPago());
                finanza.setPagoidPago(pagoidPago);
            }
            em.persist(finanza);
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getFinanzaList().add(finanza);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            if (pagoidPago != null) {
                pagoidPago.getFinanzaList().add(finanza);
                pagoidPago = em.merge(pagoidPago);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFinanza(finanza.getIdFinanza()) != null) {
                throw new PreexistingEntityException("Finanza " + finanza + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Finanza finanza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Finanza persistentFinanza = em.find(Finanza.class, finanza.getIdFinanza());
            Paciente pacienteidPacienteOld = persistentFinanza.getPacienteidPaciente();
            Paciente pacienteidPacienteNew = finanza.getPacienteidPaciente();
            Pago pagoidPagoOld = persistentFinanza.getPagoidPago();
            Pago pagoidPagoNew = finanza.getPagoidPago();
            if (pacienteidPacienteNew != null) {
                pacienteidPacienteNew = em.getReference(pacienteidPacienteNew.getClass(), pacienteidPacienteNew.getIdPaciente());
                finanza.setPacienteidPaciente(pacienteidPacienteNew);
            }
            if (pagoidPagoNew != null) {
                pagoidPagoNew = em.getReference(pagoidPagoNew.getClass(), pagoidPagoNew.getIdPago());
                finanza.setPagoidPago(pagoidPagoNew);
            }
            finanza = em.merge(finanza);
            if (pacienteidPacienteOld != null && !pacienteidPacienteOld.equals(pacienteidPacienteNew)) {
                pacienteidPacienteOld.getFinanzaList().remove(finanza);
                pacienteidPacienteOld = em.merge(pacienteidPacienteOld);
            }
            if (pacienteidPacienteNew != null && !pacienteidPacienteNew.equals(pacienteidPacienteOld)) {
                pacienteidPacienteNew.getFinanzaList().add(finanza);
                pacienteidPacienteNew = em.merge(pacienteidPacienteNew);
            }
            if (pagoidPagoOld != null && !pagoidPagoOld.equals(pagoidPagoNew)) {
                pagoidPagoOld.getFinanzaList().remove(finanza);
                pagoidPagoOld = em.merge(pagoidPagoOld);
            }
            if (pagoidPagoNew != null && !pagoidPagoNew.equals(pagoidPagoOld)) {
                pagoidPagoNew.getFinanzaList().add(finanza);
                pagoidPagoNew = em.merge(pagoidPagoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = finanza.getIdFinanza();
                if (findFinanza(id) == null) {
                    throw new NonexistentEntityException("The finanza with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Finanza finanza;
            try {
                finanza = em.getReference(Finanza.class, id);
                finanza.getIdFinanza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The finanza with id " + id + " no longer exists.", enfe);
            }
            Paciente pacienteidPaciente = finanza.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getFinanzaList().remove(finanza);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            Pago pagoidPago = finanza.getPagoidPago();
            if (pagoidPago != null) {
                pagoidPago.getFinanzaList().remove(finanza);
                pagoidPago = em.merge(pagoidPago);
            }
            em.remove(finanza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Finanza> findFinanzaEntities() {
        return findFinanzaEntities(true, -1, -1);
    }

    public List<Finanza> findFinanzaEntities(int maxResults, int firstResult) {
        return findFinanzaEntities(false, maxResults, firstResult);
    }

    private List<Finanza> findFinanzaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Finanza.class));
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

    public Finanza findFinanza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Finanza.class, id);
        } finally {
            em.close();
        }
    }

    public int getFinanzaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Finanza> rt = cq.from(Finanza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
