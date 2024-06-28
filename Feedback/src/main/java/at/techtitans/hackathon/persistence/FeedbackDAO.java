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

    /*
    String recipient = request.getParameter("recipient");
        String performance = request.getParameter("performance");
        String knowledge = request.getParameter("knowledge");
        String communication = request.getParameter("communication");
        String reliability = request.getParameter("reliability");
        String teamwork = request.getParameter("teamwork");
        String adaptability = request.getParameter("adability");
        String feedback = request.getParameter("feedback");
        String leadership = request.getParameter("leadership");
        boolean anonymous = request.getParameter("anonymous") != null;
     */

    public static boolean setNewUserFeedback(String recipient, Integer from, Integer performance, Integer knowledge, Integer communication, Integer reliability, Integer teamwork, Integer adability, Integer leadership, String feedback, Boolean anonym) {
    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    try {
        em.getTransaction().begin();
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setEmployeeIdlogin(FeedbackDAO.getEmployeeByID(FeedbackDAO.getEmployeeIdByUsername(recipient)));
        userFeedback.setIdFrom(from);
        userFeedback.setWorkPerformance(performance);
        userFeedback.setKnowledge(knowledge);
        userFeedback.setCommunication(communication);
        userFeedback.setReliability(reliability);
        userFeedback.setTeamwork(teamwork);
        userFeedback.setAdability(adability);
        userFeedback.setLeadership(leadership);
        userFeedback.setInputField(feedback);

        em.persist(userFeedback);
        em.getTransaction().commit();
        return true;
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
        return false;
    } finally {
        em.close();
    }
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
