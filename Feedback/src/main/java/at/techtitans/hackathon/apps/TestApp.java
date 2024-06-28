package at.techtitans.hackathon.apps;

import at.techtitans.hackathon.entities.Employee;
import at.techtitans.hackathon.persistence.FeedbackDAO;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        List<Employee> employees = FeedbackDAO.getAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}