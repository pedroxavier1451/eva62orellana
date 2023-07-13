package ec.edu.ups.eva62orellana.datos;

import java.util.List;

import ec.edu.ups.eva62orellana.modelo.Computador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ComputadorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Computador computador) {
		em.persist(computador);
	}
	
	public void update(Computador computador) {
		em.merge(computador);
	}

	public Computador read(int idComputador) {
		Computador c = em.find(Computador.class, idComputador);
		return c;
	}

	public void delete(int idComputador) {
		Computador c = em.find(Computador.class, idComputador);
		em.remove(c);
	}
	
	public List<Computador> getAll() {
        String jpql = "SELECT c FROM Computador c";
        TypedQuery<Computador> query = em.createQuery(jpql, Computador.class);
        return query.getResultList();
    }
}
