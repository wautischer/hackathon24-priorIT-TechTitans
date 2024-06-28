package at.techtitans.hackathon.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserFeedback", schema = "feedback_DB")
public class UserFeedback {
    @Id
    @Column(name = "idUserFeedback", nullable = false)
    private Integer id;

    @Column(name = "WorkPerformance", nullable = false)
    private Integer workPerformance;

    @Column(name = "Knowledge", nullable = false)
    private Integer knowledge;

    @Column(name = "Communication", nullable = false)
    private Integer communication;

    @Column(name = "Reliability", nullable = false)
    private Integer reliability;

    @Column(name = "Teamwork", nullable = false)
    private Integer teamwork;

    @Column(name = "Adability", nullable = false)
    private Integer adability;

    @Column(name = "Leadership")
    private Integer leadership;

    @Column(name = "InputField", nullable = false, length = 10000)
    private String inputField;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_idLogin", nullable = false)
    private Employee employeeIdlogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkPerformance() {
        return workPerformance;
    }

    public void setWorkPerformance(Integer workPerformance) {
        this.workPerformance = workPerformance;
    }

    public Integer getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Integer knowledge) {
        this.knowledge = knowledge;
    }

    public Integer getCommunication() {
        return communication;
    }

    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getReliability() {
        return reliability;
    }

    public void setReliability(Integer reliability) {
        this.reliability = reliability;
    }

    public Integer getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(Integer teamwork) {
        this.teamwork = teamwork;
    }

    public Integer getAdability() {
        return adability;
    }

    public void setAdability(Integer adability) {
        this.adability = adability;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String inputField) {
        this.inputField = inputField;
    }

    public Employee getEmployeeIdlogin() {
        return employeeIdlogin;
    }

    public void setEmployeeIdlogin(Employee employeeIdlogin) {
        this.employeeIdlogin = employeeIdlogin;
    }

}