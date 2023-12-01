/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import modelos.Paciente;
import modelos.Visita;

/**
 *
 * @author jairi
 */
public class VisitaJpaController implements Serializable {

    public VisitaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Visita visita) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteidPaciente = visita.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente = em.getReference(pacienteidPaciente.getClass(), pacienteidPaciente.getIdPaciente());
                visita.setPacienteidPaciente(pacienteidPaciente);
            }
            em.persist(visita);
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getVisitaList().add(visita);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Visita visita) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visita persistentVisita = em.find(Visita.class, visita.getIdVisita());
            Paciente pacienteidPacienteOld = persistentVisita.getPacienteidPaciente();
            Paciente pacienteidPacienteNew = visita.getPacienteidPaciente();
            if (pacienteidPacienteNew != null) {
                pacienteidPacienteNew = em.getReference(pacienteidPacienteNew.getClass(), pacienteidPacienteNew.getIdPaciente());
                visita.setPacienteidPaciente(pacienteidPacienteNew);
            }
            visita = em.merge(visita);
            if (pacienteidPacienteOld != null && !pacienteidPacienteOld.equals(pacienteidPacienteNew)) {
                pacienteidPacienteOld.getVisitaList().remove(visita);
                pacienteidPacienteOld = em.merge(pacienteidPacienteOld);
            }
            if (pacienteidPacienteNew != null && !pacienteidPacienteNew.equals(pacienteidPacienteOld)) {
                pacienteidPacienteNew.getVisitaList().add(visita);
                pacienteidPacienteNew = em.merge(pacienteidPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visita.getIdVisita();
                if (findVisita(id) == null) {
                    throw new NonexistentEntityException("The visita with id " + id + " no longer exists.");
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
            Visita visita;
            try {
                visita = em.getReference(Visita.class, id);
                visita.getIdVisita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visita with id " + id + " no longer exists.", enfe);
            }
            Paciente pacienteidPaciente = visita.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getVisitaList().remove(visita);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.remove(visita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Visita> findVisitaEntities() {
        return findVisitaEntities(true, -1, -1);
    }

    public List<Visita> findVisitaEntities(int maxResults, int firstResult) {
        return findVisitaEntities(false, maxResults, firstResult);
    }

    private List<Visita> findVisitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Visita.class));
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

    public Visita findVisita(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Visita.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Visita> findVisitaByFechaYHora(Date fecha, String hora){
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT v FROM Visita v WHERE v.fecha = :fecha AND v.hora = :hora";
            TypedQuery<Visita> query = em.createQuery(jpql, Visita.class);
            query.setParameter("fecha", fecha);  
            query.setParameter("hora", hora);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public int getVisitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Visita> rt = cq.from(Visita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Visita> buscarVisitaPorAsunto(String nombreCompleto) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT v FROM Visita v " +
                          "WHERE LOWER(CONCAT(v.asunto, ' ', v.familiar, ' ', v.parentesco)) LIKE LOWER(:nombreCompleto) ";

            TypedQuery<Visita> query = em.createQuery(jpql, Visita.class);
            query.setParameter("nombreCompleto", "%" + nombreCompleto + "%");

            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
