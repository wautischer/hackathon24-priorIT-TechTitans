package at.techtitans.hackathon.persistence;

import at.techtitans.hackathon.entities.Employee;
import at.techtitans.hackathon.entities.Login;
import at.techtitans.hackathon.entities.UserFeedback;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public static List<Employee> getAllEmployee() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("select u from Employee u", Employee.class).getResultList();
    }

    public static boolean checkPassword(String password, String username) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Login> query = em.createQuery("select u from Login u where u.username like ?1", Login.class);
            Login login = query.setParameter(1, username).getSingleResult();
            return login.getPassword().equals(password);
        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

    public static Integer getEmployeeIdByUsername(String username) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Login> query = em.createQuery("select u from Login u where u.username = ?1", Login.class);
        return query.setParameter(1, username).getSingleResult().getId();
    }

    public static Employee getEmployeeByID(Integer id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Employee> query = em.createQuery("select u from Employee u where u.id = ?1", Employee.class);
        return query.setParameter(1, id).getSingleResult();
    }

    public static List<UserFeedback> getRatingsByEmployeeID(Integer id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<UserFeedback> query = em.createQuery("select f from UserFeedback f where f.employeeIdlogin = ?1", UserFeedback.class);
        return query.setParameter(1, id).getResultList();
    }

    public static List<String> getFeedbackData(UserFeedback uf) {
        List<String> feedbackData = new ArrayList<>();
        feedbackData.add(uf.getWorkPerformance().toString());
        feedbackData.add(uf.getKnowledge().toString());
        feedbackData.add(uf.getCommunication().toString());
        feedbackData.add(uf.getReliability().toString());
        feedbackData.add(uf.getTeamwork().toString());
        feedbackData.add(uf.getAdability().toString());
        if (uf.getLeadership() != null) {
            feedbackData.add(uf.getLeadership().toString());
        }
        return feedbackData;
    }
}
