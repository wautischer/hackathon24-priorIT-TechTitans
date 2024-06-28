package at.techtitans.hackathon.persistence;

import at.techtitans.hackathon.entities.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FeedbackDAO {
    public static List<Employee> getAllEmployee() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("select u from Employee u", Employee.class).getResultList();
    }
}
