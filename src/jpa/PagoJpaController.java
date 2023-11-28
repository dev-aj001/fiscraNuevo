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
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.Pago;

/**
 *
 * @author jairi
 */
public class PagoJpaController implements Serializable {

    public PagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pago pago) {
        if (pago.getFinanzaList() == null) {
            pago.setFinanzaList(new ArrayList<Finanza>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Finanza> attachedFinanzaList = new ArrayList<Finanza>();
            for (Finanza finanzaListFinanzaToAttach : pago.getFinanzaList()) {
                finanzaListFinanzaToAttach = em.getReference(finanzaListFinanzaToAttach.getClass(), finanzaListFinanzaToAttach.getIdFinanza());
                attachedFinanzaList.add(finanzaListFinanzaToAttach);
            }
            pago.setFinanzaList(attachedFinanzaList);
            em.persist(pago);
            for (Finanza finanzaListFinanza : pago.getFinanzaList()) {
                Pago oldPagoidPagoOfFinanzaListFinanza = finanzaListFinanza.getPagoidPago();
                finanzaListFinanza.setPagoidPago(pago);
                finanzaListFinanza = em.merge(finanzaListFinanza);
                if (oldPagoidPagoOfFinanzaListFinanza != null) {
                    oldPagoidPagoOfFinanzaListFinanza.getFinanzaList().remove(finanzaListFinanza);
                    oldPagoidPagoOfFinanzaListFinanza = em.merge(oldPagoidPagoOfFinanzaListFinanza);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pago pago) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pago persistentPago = em.find(Pago.class, pago.getIdPago());
            List<Finanza> finanzaListOld = persistentPago.getFinanzaList();
            List<Finanza> finanzaListNew = pago.getFinanzaList();
            List<String> illegalOrphanMessages = null;
            for (Finanza finanzaListOldFinanza : finanzaListOld) {
                if (!finanzaListNew.contains(finanzaListOldFinanza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Finanza " + finanzaListOldFinanza + " since its pagoidPago field is not nullable.");
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
            pago.setFinanzaList(finanzaListNew);
            pago = em.merge(pago);
            for (Finanza finanzaListNewFinanza : finanzaListNew) {
                if (!finanzaListOld.contains(finanzaListNewFinanza)) {
                    Pago oldPagoidPagoOfFinanzaListNewFinanza = finanzaListNewFinanza.getPagoidPago();
                    finanzaListNewFinanza.setPagoidPago(pago);
                    finanzaListNewFinanza = em.merge(finanzaListNewFinanza);
                    if (oldPagoidPagoOfFinanzaListNewFinanza != null && !oldPagoidPagoOfFinanzaListNewFinanza.equals(pago)) {
                        oldPagoidPagoOfFinanzaListNewFinanza.getFinanzaList().remove(finanzaListNewFinanza);
                        oldPagoidPagoOfFinanzaListNewFinanza = em.merge(oldPagoidPagoOfFinanzaListNewFinanza);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pago.getIdPago();
                if (findPago(id) == null) {
                    throw new NonexistentEntityException("The pago with id " + id + " no longer exists.");
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
            Pago pago;
            try {
                pago = em.getReference(Pago.class, id);
                pago.getIdPago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pago with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Finanza> finanzaListOrphanCheck = pago.getFinanzaList();
            for (Finanza finanzaListOrphanCheckFinanza : finanzaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pago (" + pago + ") cannot be destroyed since the Finanza " + finanzaListOrphanCheckFinanza + " in its finanzaList field has a non-nullable pagoidPago field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(pago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pago> findPagoEntities() {
        return findPagoEntities(true, -1, -1);
    }

    public List<Pago> findPagoEntities(int maxResults, int firstResult) {
        return findPagoEntities(false, maxResults, firstResult);
    }

    private List<Pago> findPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pago.class));
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

    public Pago findPago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pago.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pago> rt = cq.from(Pago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
